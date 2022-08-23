package com.exercicio.ContaBancaria.service;

import com.exercicio.ContaBancaria.model.ContaBancariaModel;
import com.exercicio.ContaBancaria.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    @Autowired

    private ContaBancariaRepository repository;

    public List<ContaBancariaModel> buscarContas(){
        return repository.findAll();
    }

    public Optional<ContaBancariaModel> buscarContaPorId(Long id){
        return repository.findById(id);
    }

    public ContaBancariaModel cadastrar (ContaBancariaModel conta){
        ContaBancariaFactory contaFactory = new ContaBancariaFactory();
        BigDecimal resultado = contaFactory.calculoConta(conta.getTipoServico().calculoConta(conta));

        conta.getId();
        conta.getNumeroDeConta();
        conta.getValorAtualDaConta();
        conta.getNomeDoUsuario();
        conta.getAgencia();
        conta.setValorFinal(resultado);
        conta.getValorFornecido();
        conta.getTipoServico();
        return repository.save(conta);
    }

    public ContaBancariaModel alterar(ContaBancariaModel conta){
        ContaBancariaFactory contaFactory = new ContaBancariaFactory();
        BigDecimal resultado = contaFactory.calculoConta(conta.getTipoServico().calculoConta(conta));

        conta.getId();
        conta.getNumeroDeConta();
        conta.getValorAtualDaConta();
        conta.getNomeDoUsuario();
        conta.getAgencia();
        conta.setValorFinal(resultado);
        conta.getValorFornecido();
        conta.getTipoServico();
        return repository.save(conta);
    }

    public void deletar (Long id){
        repository.deleteById(id);
    }



}
