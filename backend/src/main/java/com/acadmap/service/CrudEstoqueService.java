package com.acadmap.service;


import com.acadmap.model.Estoque;
import com.acadmap.model.dto.EstoqueDTO;
import com.acadmap.repository.EstoqueRepository;
import com.acadmap.repository.LojaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CrudEstoqueService {

    private EstoqueRepository estoqueRepository;


    private ModelMapper modelMapper;

    @Transactional
    public Estoque createEstoque(Estoque estoque){
//        estoque.setNumero(estoque.getNumero() + 100000000);
        estoqueRepository.save(estoque);
        return estoqueRepository.findById(estoque.getId()).orElseThrow(EntityNotFoundException::new);
    }


    @Transactional
    public List<EstoqueDTO> readEstoque(){
        return estoqueRepository.findAll()
                .stream().map(
                        estoque -> modelMapper.map(estoque, EstoqueDTO.class)
                ).toList();
    }

    @Transactional
    public Estoque updateEstoque(Estoque estoqueAtualizado){
        Estoque estoqueAtual = estoqueRepository.findById(estoqueAtualizado.getId()).orElseThrow();
        BeanUtils.copyProperties(estoqueAtualizado, estoqueAtual, "id", "lojas");
        return estoqueRepository.save(estoqueAtualizado);
    }

    @Transactional
    public void deleteEstoque(Long id){
       estoqueRepository.deleteById(id);
    }





}
