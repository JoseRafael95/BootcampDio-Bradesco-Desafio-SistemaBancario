package com.SistemaBancario.SistemaBancario.Controller;

import com.SistemaBancario.SistemaBancario.Model.Client;
import com.SistemaBancario.SistemaBancario.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping
    void register(@RequestBody Client client){
    clientService.register(client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable long id) {
        return clientService.findById(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable long id, @RequestBody Client cliente){
        clientService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id){
        clientService.delete(id);
    }
}
