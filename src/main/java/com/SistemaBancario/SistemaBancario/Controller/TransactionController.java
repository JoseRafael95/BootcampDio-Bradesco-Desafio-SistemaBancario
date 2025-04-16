package com.SistemaBancario.SistemaBancario.Controller;

import com.SistemaBancario.SistemaBancario.Model.Transaction;
import com.SistemaBancario.SistemaBancario.Service.Imp.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionServiceImp transaction;

    @PostMapping("/transferencia")
    void traferir(@RequestParam long origem, @RequestParam long destino, @RequestParam double valor){
        transaction.transferencia(destino,origem,valor);

    }

    @PostMapping("/deposito")
    void depositar(@RequestParam long id, @RequestParam double valor) {
        transaction.deposito(id, valor);
    }

    @PostMapping("/compra")
        void compra(@RequestParam long id, @RequestParam double valor){
        transaction.compra(id, valor);
    }
}
