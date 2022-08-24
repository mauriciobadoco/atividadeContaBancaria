package com.exercicio.ContaBancaria.controller;

import com.exercicio.ContaBancaria.model.ContaBancariaModel;
import com.exercicio.ContaBancaria.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService service;

    @GetMapping (path = "/conta")
    public ResponseEntity<List<ContaBancariaModel>> buscarConta(){
        List<ContaBancariaModel>listaContas = service.buscarContas();
        return ResponseEntity.ok(listaContas);
    }

    @GetMapping (path = "/conta/{id}")
    public ResponseEntity<Optional<ContaBancariaModel>> buscarContaPorId(@PathVariable Long id){

        return ResponseEntity.ok(service.buscarContaPorId(id));
    }

    @PostMapping (path = "/conta")
    public ResponseEntity<ContaBancariaModel> cadastrar(@RequestBody ContaBancariaModel conta){
        ContaBancariaModel contaBancaria = service.cadastrar(conta);
        return new ResponseEntity<>(contaBancaria, HttpStatus.CREATED);
    }

    @PutMapping (path = "/conta{id}")
    public ResponseEntity<ContaBancariaModel> alterar(@RequestBody ContaBancariaModel contaBancariaModel){
        return  ResponseEntity.ok(contaBancariaModel);
    }

    @DeleteMapping (path = "/conta{id}")
    public void  deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
