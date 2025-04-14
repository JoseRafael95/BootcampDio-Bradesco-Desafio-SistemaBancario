package com.SistemaBancario.SistemaBancario.Service;

import com.SistemaBancario.SistemaBancario.Model.Account;
import com.SistemaBancario.SistemaBancario.Model.Client;

public interface AccountService {
    void openAccount(long id, Account account);
    Account update(long id, Account account);
    void delete(long id);
}
