package br.com.bytebank.operation;

import br.com.bytebank.model.Conta;

public interface OperacaoBancaria {
    void executar(Conta conta, int valor);
}
