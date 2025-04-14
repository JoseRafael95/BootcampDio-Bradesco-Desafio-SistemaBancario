package com.SistemaBancario.SistemaBancario.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="tb_account")
public class Account {
    @Id
    private long id;
    private String number;
    private double balance;
    private double accountLimit;
    @OneToOne
    @JoinColumn(name ="creditCard")
    private CreditCard creditCard;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(double accountLimit) {
        this.accountLimit = accountLimit;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
