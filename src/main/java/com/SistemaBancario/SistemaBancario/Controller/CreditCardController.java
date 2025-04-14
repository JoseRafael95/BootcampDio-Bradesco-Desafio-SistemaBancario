package com.SistemaBancario.SistemaBancario.Controller;

import com.SistemaBancario.SistemaBancario.Model.CreditCard;
import com.SistemaBancario.SistemaBancario.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client/{id}/account/card")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @PostMapping
    void newCard(@PathVariable Long id, @RequestBody CreditCard card){
        creditCardService.newCard(id, card);
    }

    @DeleteMapping
    void DeleteCard(@PathVariable Long id){
        creditCardService.deleteCard(id);
    }
}
