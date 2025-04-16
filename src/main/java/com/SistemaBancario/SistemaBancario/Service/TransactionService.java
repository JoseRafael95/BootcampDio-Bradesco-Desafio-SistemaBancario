package com.SistemaBancario.SistemaBancario.Service;

import com.SistemaBancario.SistemaBancario.Model.Transaction;

public interface TransactionService {


 Transaction transfer(
         Long destinationAccoutId,
         Long originAccountId,
         Double valueTransfer);

 Transaction deposit(
         Long id,
         double valor );

Transaction buy(Long id,
                double valor);

}
