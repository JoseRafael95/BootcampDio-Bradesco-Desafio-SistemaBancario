package com.SistemaBancario.SistemaBancario.Service;

import com.SistemaBancario.SistemaBancario.Model.CreditCard;

public interface CreditCardService {

    void newCard(Long id, CreditCard card);

    void deleteCard(Long id);


}
