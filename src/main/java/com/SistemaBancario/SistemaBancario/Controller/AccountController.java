package com.SistemaBancario.SistemaBancario.Controller;

import com.SistemaBancario.SistemaBancario.Model.Account;
import com.SistemaBancario.SistemaBancario.Model.Client;
import com.SistemaBancario.SistemaBancario.Model.ClientRepository;
import com.SistemaBancario.SistemaBancario.Service.AccountService;
import com.SistemaBancario.SistemaBancario.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client/{id}/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    ClientService clientService;

    @PostMapping
    Account newAccount(@PathVariable long id, @RequestBody Account account){
        accountService.openAccount(id, account);

        return account;
    }

    @PutMapping
    Account updateAccount(@PathVariable long id, @RequestBody Account account) {
        return accountService.update(id, account); // Retorna a conta atualizada pelo service
    }

    @DeleteMapping
    void delete(@PathVariable long id){
        accountService.delete(id);

    }

}
