package com.SistemaBancario.SistemaBancario.Service.Imp;

import com.SistemaBancario.SistemaBancario.Model.*;
import com.SistemaBancario.SistemaBancario.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreditCardServiceImp implements CreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public void newCard(Long id, CreditCard card) {
        Account account = accountRepository.findById(id).get();
        CreditCard saveCard = creditCardRepository.save(card);
        account.setCreditCard(saveCard);

        accountRepository.save(account);

    }
    @Override
    public void deleteCard(Long id) {
        Account account = accountRepository.findById(id).get();
        account.setCreditCard(null);

        creditCardRepository.deleteById(id);
    }
}
