package com.SistemaBancario.SistemaBancario.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    @OneToOne
    @JoinColumn(name = "tb_account")
    private Account accounts;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

}
