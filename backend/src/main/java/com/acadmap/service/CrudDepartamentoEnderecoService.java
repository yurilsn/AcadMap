package com.acadmap.service;


import com.acadmap.model.Departamento;
import com.acadmap.model.Endereco;
import com.acadmap.repository.DepartamentoRepository;
import com.acadmap.repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CrudDepartamentoEnderecoService {

    private DepartamentoRepository departamentoRepository;
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Departamento createDepartamentoEndereco(Departamento departamento){
        return departamentoRepository.save(departamento);

    }

    @Transactional
    public List<Departamento> readDepartamentoEndereco(){
        return departamentoRepository.findAll();

    }

    @Transactional
    public Departamento updateDepartamentoEndereco(Departamento departamentoAtualizado, Long id){
        Departamento departamentoAtual = departamentoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BeanUtils.copyProperties(departamentoAtualizado, departamentoAtual, "id", "enderecos");
        departamentoAtual.getEnderecos().clear();
        departamentoAtualizado.getEnderecos().forEach(
                enderecoAtualizado -> {
                    enderecoRepository.save(enderecoAtualizado);
                    departamentoAtual.adicionarEndereco(enderecoAtualizado);
                }
        );
        return departamentoRepository.save(departamentoAtual);
    }
}
