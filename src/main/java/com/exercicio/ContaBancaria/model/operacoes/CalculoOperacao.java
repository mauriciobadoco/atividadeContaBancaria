package com.exercicio.ContaBancaria.model.operacoes;

import com.exercicio.ContaBancaria.model.ContaBancariaModel;

import java.math.BigDecimal;

public interface CalculoOperacao {

    BigDecimal calculoOperacao(ContaBancariaModel contaBancariaModel);

}
