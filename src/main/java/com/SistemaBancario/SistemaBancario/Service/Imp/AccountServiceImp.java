package com.SistemaBancario.SistemaBancario.Service.Imp;

import com.SistemaBancario.SistemaBancario.Model.Account;
import com.SistemaBancario.SistemaBancario.Model.AccountRepository;
import com.SistemaBancario.SistemaBancario.Model.Client;
import com.SistemaBancario.SistemaBancario.Model.ClientRepository;
import com.SistemaBancario.SistemaBancario.Service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void openAccount(long id, Account account) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Client not found"));
        accountRepository.save(account);
        client.setAccounts(account);
        clientRepository.save(client);

    }

    @Override
    @Transactional
    public Account update(long id, Account account) {
        Account exitingAccount =  accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));

        exitingAccount.setId(id);
        exitingAccount.setBalance(account.getBalance());
        exitingAccount.setAccountLimit(account.getAccountLimit());
        Account updatedAccount = accountRepository.save(exitingAccount);

        return updatedAccount;

    }

    @Override
    public void delete(long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));

        client.setAccounts(null);
        clientRepository.save(client);

        accountRepository.delete(account);

    }

}