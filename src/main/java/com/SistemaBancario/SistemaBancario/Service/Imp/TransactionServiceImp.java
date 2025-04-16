package com.SistemaBancario.SistemaBancario.Service.Imp;

import com.SistemaBancario.SistemaBancario.Model.*;
import com.SistemaBancario.SistemaBancario.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
@Service
public class TransactionServiceImp implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public void trasaction(
    String tipo,
    double valueTransaction,
    long contaOrigem,
    long contaDestino,
    double payCard ) {


    }
    @Transactional
    public Transaction transferencia(Long conta_destino_id, Long conta_origem_id, Double valor){
        Account contaOrigem = accountRepository.findById(conta_origem_id)
                .orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));

        Account contaDestino = accountRepository.findById(conta_destino_id)
                .orElseThrow(() -> new RuntimeException("Conta destino não encotrada"));

        if(contaOrigem.getBalance() < valor ){
            throw new RuntimeException("Saldo insulficiente");
        }else{
            contaOrigem.setBalance(contaOrigem.getBalance() - valor);
            contaDestino.setBalance(contaDestino.getBalance() + valor);
        }

        Transaction tranferencia = new Transaction();
        tranferencia.setTipo("TRANSFERENCIA");
        tranferencia.setContaOrigem(contaOrigem);
        tranferencia.setContaDestino(contaDestino);
        tranferencia.setValueTransaction(valor);
         return transactionRepository.save(tranferencia);


    }

    @Transactional
    public Transaction deposito(Long id, double valor ){
        Account conta = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Conta não encotrada"));
        if(valor < 0){
            throw new RuntimeException("Valor invalido");
        }else {
            conta.setBalance(conta.getBalance() + valor);
        }
        accountRepository.save(conta);
        Transaction transacao = new Transaction();
        transacao.setTipo("DEPOSITO");
        transacao.setValueTransaction(valor);
        transacao.setContaDestino(conta);

        return transactionRepository.save(transacao);

    }

    @Transactional
    public Transaction compra(Long id, double valor) {
        CreditCard cartao = creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encotrado."));

        if (valor > cartao.getCardLimit()) {
            throw new RuntimeException("Valor é superior ao limite do cartão");
        }
        Account conta = cartao.getAccount();
        conta.setBalance(conta.getBalance() - valor);

        Transaction transacao = new Transaction();
        transacao.setTipo("COMPRA");
        transacao.setContaOrigem(conta);
        transacao.setValueTransaction(valor);

        return transactionRepository.save(transacao);

    }

}
