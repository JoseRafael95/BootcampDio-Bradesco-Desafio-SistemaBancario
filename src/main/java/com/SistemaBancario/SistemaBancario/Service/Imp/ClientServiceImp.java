package com.SistemaBancario.SistemaBancario.Service.Imp;

import com.SistemaBancario.SistemaBancario.Model.Client;
import com.SistemaBancario.SistemaBancario.Model.ClienteRepository;
import com.SistemaBancario.SistemaBancario.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public void register(Client client) {
        clienteRepository.save(client);
    }

    @Override
    public void consultation(long id) {
        clienteRepository.findById(id);
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
