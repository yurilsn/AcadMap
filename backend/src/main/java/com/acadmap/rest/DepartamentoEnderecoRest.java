package com.acadmap.rest;


import com.acadmap.model.Departamento;
import com.acadmap.model.Estoque;
import com.acadmap.service.CrudDepartamentoEnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/many-to-many/departamento-endereco")
@AllArgsConstructor
public class DepartamentoEnderecoRest {

    private CrudDepartamentoEnderecoService crudDepartamentoEnderecoService;

    @PostMapping
    public Departamento creadEstoqueLoja(@RequestBody Departamento departamento){
        return crudDepartamentoEnderecoService.createDepartamentoEndereco(departamento);
    }

    @GetMapping
    public List<Departamento> readEstoqueLoja(){
        return crudDepartamentoEnderecoService.readDepartamentoEndereco();
    }

    @PutMapping("{id}")
    public Departamento updateEstoqueLoja(@RequestBody Departamento departamento, @PathVariable Long id){
        return crudDepartamentoEnderecoService.updateDepartamentoEndereco(departamento, id);
    }



}
