package com.SistemaBancario.SistemaBancario.Service.Imp;

import com.SistemaBancario.SistemaBancario.Model.AccountRepository;
import com.SistemaBancario.SistemaBancario.Model.Client;
import com.SistemaBancario.SistemaBancario.Model.ClientRepository;
import com.SistemaBancario.SistemaBancario.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository clienteRepository;



    @Override
    public void register(Client client) {
        clienteRepository.save(client);
    }

    @Override
    public Client findById(long id) {
        Optional<Client> client = clienteRepository.findById(id);
        Client existingClient = client.get();
        return existingClient;
    }

    @Override
    public void update(long id, Client client) {
        Optional<Client> existingClientOptional = clienteRepository.findById(id);
        Client existingClient = existingClientOptional.get();
        existingClient.setId(id);
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());

    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }
}
