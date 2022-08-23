package com.exercicio.ContaBancaria.model.operacoes;

import com.exercicio.ContaBancaria.model.ContaBancariaModel;

import java.math.BigDecimal;

public class SaqueImpl implements CalculoOperacao{

    @Override

    public BigDecimal calculoOperacao(ContaBancariaModel contaBancariaModel){
        BigDecimal resultado = contaBancariaModel.getValorFinal().subtract(contaBancariaModel.getValorFornecido());
        return resultado;

    }
}
