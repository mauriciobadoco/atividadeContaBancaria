package com.exercicio.ContaBancaria.model.operacoes;

import java.math.BigDecimal;

public class OperacaoFactory {

    public CalculoOperacao calculoOperacao (String tipoServico){

        if(tipoServico.equalsIgnoreCase("SAQUE")){
            return new SaqueImpl();
        }else if (tipoServico.equals("DEPOSITO")){
            return new DepositoImpl();
        }
        return null;
    }
}
