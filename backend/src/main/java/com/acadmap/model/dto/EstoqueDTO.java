package com.acadmap.model.dto;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EstoqueDTO {

    private Long id;

    private String nome;

    private Integer numero;
}
