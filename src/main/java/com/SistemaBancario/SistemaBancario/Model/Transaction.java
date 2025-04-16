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

    @ManyToOne
    @JoinColumn(name = "conta_orige_id")
    private Account contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    private Account contaDestino;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private CreditCard creditCard;

    @ManyToOne
    @JoinColumn(name="account")
    private Account account;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValueTransaction() {
        return valueTransaction;
    }

    public void setValueTransaction(double valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

    public Account getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Account contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Account getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Account contaDestino) {
        this.contaDestino = contaDestino;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}


