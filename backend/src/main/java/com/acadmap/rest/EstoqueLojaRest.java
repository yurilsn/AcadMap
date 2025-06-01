package com.acadmap.rest;


import com.acadmap.model.Estoque;
import com.acadmap.service.CrudEstoqueLojaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/one-to-many/estoque-loja")
@AllArgsConstructor
public class EstoqueLojaRest {

    private CrudEstoqueLojaService crudEstoqueLojaService;


    @PostMapping
    public Estoque creadEstoqueLoja(@RequestBody Estoque estoque){
        return crudEstoqueLojaService.createEstoqueLojas(estoque);
    }

    @GetMapping
    public List<Estoque> readEstoqueLoja(){
        return crudEstoqueLojaService.readEstoqueLoja();
    }

    @PutMapping("/{id}")
    public Estoque updateEstoqueLoja(@RequestBody Estoque estoque, @PathVariable Long id){
        return crudEstoqueLojaService.updateEstoqueLoja(estoque, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEstoqueLoja(@PathVariable Long id){
        crudEstoqueLojaService.deleteEstoqueLojas(id);
    }
}
