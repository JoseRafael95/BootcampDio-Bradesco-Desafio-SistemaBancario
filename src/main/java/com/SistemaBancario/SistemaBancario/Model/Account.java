package com.SistemaBancario.SistemaBancario.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    private double balance;
    private double accountLimit;
    @OneToOne
    @JoinColumn(name ="creditCard")
    private CreditCard creditCard;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
