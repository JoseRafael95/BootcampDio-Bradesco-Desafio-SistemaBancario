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
}
