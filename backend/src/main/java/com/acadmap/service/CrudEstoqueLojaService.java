package com.acadmap.service;


import com.acadmap.model.Estoque;
import com.acadmap.repository.EstoqueRepository;
import com.acadmap.repository.LojaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CrudEstoqueLojaService {

    private EstoqueRepository estoqueRepository;

    private LojaRepository lojaRepository;

    private ModelMapper modelMapper;

    @Transactional
    public Estoque createEstoqueLojas(Estoque estoque){
        estoque.adicionarLojas(estoque.getLojas());
        return estoqueRepository.save(estoque);
    }

    @Transactional
    public List<Estoque> readEstoqueLoja(){
        return estoqueRepository.findAll();
    }

    @Transactional
    public Estoque updateEstoqueLoja(Estoque estoqueAtualizado, Long id){
        Estoque estoqueAtual = estoqueRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(estoqueAtualizado, estoqueAtual, "id");
        estoqueAtual.removerLojas();
        estoqueAtual.adicionarLojas(lojaRepository.saveAll(estoqueAtualizado.getLojas()));
        return estoqueRepository.save(estoqueAtual);
    }

    @Transactional
    public void teste(Long id){
        Estoque estoqueAtual = estoqueRepository.findById(id).orElseThrow();
        estoqueAtual.removerLojas();
    }


    @Transactional
    public void deleteEstoqueLojas(Long id){
        estoqueRepository.deleteById(id);
    }


}
