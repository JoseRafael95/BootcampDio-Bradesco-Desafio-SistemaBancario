package com.SistemaBancario.SistemaBancario.Service.Imp;

import com.SistemaBancario.SistemaBancario.Model.*;
import com.SistemaBancario.SistemaBancario.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;

@Service
public class TransactionServiceImp implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CreditCardRepository creditCardRepository;

//    @Override
//    public void trasaction(
//    String tipo,
//    double valueTransaction,
//    long contaOrigem,
//    long contaDestino,
//    double payCard ) {
//
//
//    }

    @Transactional
    public Transaction transfer(Long destinationAccountId, Long originAccountId, Double valueTransfer){
        Account originAccount = accountRepository.findById(originAccountId)
                .orElseThrow(() -> new RuntimeException("Origin account not found"));

        Account destinationAccount = accountRepository.findById(destinationAccountId)
                .orElseThrow(() -> new RuntimeException("Destination account not found"));

        if(originAccount.getBalance() < valueTransfer ){
            throw new RuntimeException("Insufficient balance");
        }else{
            originAccount.setBalance(originAccount.getBalance() - valueTransfer);
            destinationAccount.setBalance(destinationAccount.getBalance() + valueTransfer);
        }

        Transaction transaction = new Transaction();
        transaction.setTipo("TRANSFER");
        transaction.setContaOrigem(originAccount);
        transaction.setContaDestino(destinationAccount);
        transaction.setValueTransaction(valueTransfer);
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction deposit(Long id, double valueDeposit ){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if(valueDeposit < 0){
            throw new RuntimeException("Invalid amount");
        }else {
            account.setBalance(account.getBalance() + valueDeposit);
        }
        accountRepository.save(account);
        Transaction transaction = new Transaction();
        transaction.setTipo("DEPOSIT");
        transaction.setValueTransaction(valueDeposit);
        transaction.setContaDestino(account);

        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction buy(Long id, double valueBuy) {
        CreditCard card = creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found."));

        Account account =  accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not fount"));

        if (valueBuy > card.getCardLimit()) {
            throw new RuntimeException("Amount exceeds card limit");
        }
        Account accountCard = card.getAccount();
        account.setBalance(accountCard.getBalance() - valueBuy);

        Transaction transaction = new Transaction();

        transaction.setTipo("PURCHASE");
        transaction.setContaOrigem(accountCard);
        transaction.setValueTransaction(valueBuy);

        creditCardRepository.save(card);

        account.getTransactions().add(transaction);
        accountRepository.save(account);

        return transactionRepository.save(transaction);
    }
}
