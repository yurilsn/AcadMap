package com.acadmap.model;

import com.acadmap.model.dto.EstoqueDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "ESTOQUE")
@DynamicUpdate
@DynamicInsert
@ToString(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Estoque.class
)
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;


    @Column
    private Integer numero;



    @OneToMany(mappedBy = "estoque",cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnoreProperties("estoque")
    private List<Loja> lojas;


    public void adicionarLoja(Loja loja) {
        lojas.add(loja);
        loja.setEstoque(this);
    }


    public List<Loja> adicionarLojas(List<Loja> lojas) {
        lojas.addAll(lojas);
        lojas.forEach(
                loja -> loja.setEstoque(this)
        );
        return lojas;
    }


    public void removerLoja(Loja loja) {
        this.lojas.remove(loja);
        loja.setEstoque(null);
    }


    public void removerLojas() {
        this.lojas.clear();
    }



}
