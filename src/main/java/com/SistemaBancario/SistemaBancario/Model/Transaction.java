package com.SistemaBancario.SistemaBancario.Model;

import jakarta.persistence.*;



@Entity
@Table(name = "tb_transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    private String tipo;
    private double valueTransaction;
    private long contaOrigem;
    private long contaDestino;
    @ManyToOne()
    @JoinColumn(name = "account")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "credit_id")
    private CreditCard creditCard;

}
