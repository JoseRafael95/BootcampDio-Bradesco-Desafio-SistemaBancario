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
    @JoinColumn(name = "account_id")
    private Account accounts;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
