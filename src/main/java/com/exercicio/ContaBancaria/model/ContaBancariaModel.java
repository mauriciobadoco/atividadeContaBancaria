package com.exercicio.ContaBancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "contabancaria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContaBancariaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 50, nullable = false)
    private Long numeroDeConta;

    @Column (length = 200, nullable = false)
    private String nomeDoUsuario;

    @Column (length = 50, nullable = false)
    private Long agencia;

    @Column (length = 50, nullable = false)
    private BigDecimal valorAtualDaConta;

    @Column (length = 50)
    private BigDecimal valorFinal;

    @Column (length = 50, nullable = false)
    private BigDecimal valorFornecido;

    @Column (length = 100, nullable = false)
    private String tipoServico;
}
