package com.acadmap.rest;


import com.acadmap.model.Estoque;
import com.acadmap.model.dto.EstoqueDTO;
import com.acadmap.service.CrudEstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estoque")
@AllArgsConstructor
public class EstoqueRest {

    private CrudEstoqueService crudEstoqueService;



    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque){
        return crudEstoqueService.createEstoque(estoque);
    }

    @GetMapping
    public List<EstoqueDTO> readEstoque(){
        return crudEstoqueService.readEstoque();
    }

    @PutMapping
    public Estoque updateEstoque(@RequestBody Estoque estoque){
        return crudEstoqueService.updateEstoque(estoque);
    }

    @DeleteMapping("/{id}")
    public void deleteEstoque(@PathVariable Long id){
        crudEstoqueService.deleteEstoque(id);
    }




}
