package br.com.bytebank.operation;

public final class OperacaoFactory {
    private OperacaoFactory() {
    }

    public static OperacaoBancaria criar(String tipo) {
        if ("DEPOSITAR".equals(tipo)) {
            return new Deposito();
        }
        if ("SACAR".equals(tipo)) {
            return new Saque();
        }
        // A validação informa a mensagem de erro antes de executar a operação.
        return (conta, valor) -> { };
    }
}
