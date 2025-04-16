package com.SistemaBancario.SistemaBancario.Service;

public interface TransactionService {
 void trasaction(
         String tipo,
         double valueTransaction,
         long contaOrigem,
         long contaDestino,
         double payCard
 );
}
