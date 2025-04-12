package com.SistemaBancario.SistemaBancario.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mensage;
    @ManyToOne
    @JoinColumn(name ="cliente_id")
    private Client client;
}
