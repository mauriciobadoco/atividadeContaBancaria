package com.exercicio.ContaBancaria.model.operacoes;

import com.exercicio.ContaBancaria.model.ContaBancariaModel;

import java.math.BigDecimal;

public class DepositoImpl implements CalculoOperacao{

    @Override
    public  BigDecimal calculoOperacao(ContaBancariaModel contaBancariaModel){
        BigDecimal resultado = contaBancariaModel.getValorAtualDaConta().add(contaBancariaModel.getValorFornecido());
        return resultado;
    }

}
