package br.com.bytebank.operation;

import br.com.bytebank.model.Conta;

public class Deposito implements OperacaoBancaria {
    @Override
    public void executar(Conta conta, int valor) {
        conta.depositar(valor);
    }
}
