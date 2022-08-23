package com.exercicio.ContaBancaria.controller;

import com.exercicio.ContaBancaria.model.ContaBancariaModel;
import com.exercicio.ContaBancaria.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaBancariaController {

    @Autowired

    private ContaBancariaService service;

    @GetMapping (path = "/conta")
    public List<ContaBancariaModel> buscarConta(){
        return service.buscarContas();
    }

    @GetMapping (path = "/conta/{id}")
    public Optional<ContaBancariaModel> buscarContaPorId(@PathVariable Long id){
        return service.buscarContaPorId(id);
    }

    @PostMapping (path = "/conta")
    public ContaBancariaModel cadastrar(@RequestBody ContaBancariaModel conta){
        return service.cadastrar(conta);
    }

    @PutMapping (path = "/conta{id}")
    public ContaBancariaModel alterar(@RequestBody ContaBancariaModel contaBancariaModel){
        return  service.alterar(contaBancariaModel);
    }

    @DeleteMapping (path = "/conta{id}")
    public void  deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
