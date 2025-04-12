package com.SistemaBancario.SistemaBancario.Service;

import com.SistemaBancario.SistemaBancario.Model.Client;
import com.SistemaBancario.SistemaBancario.Model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ClientService {
    void register(Client client);
    void consultation(long id);
    void update(long id, Client client);
    void delete(long id);
}
