package com.SistemaBancario.SistemaBancario.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_credit")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long number;
    private Date expirationDate;
    private double cardLimit;
    @OneToMany(mappedBy = "creditCard")
    private List<Transaction> transactions;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(double cardLimit) {
        this.cardLimit = cardLimit;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
