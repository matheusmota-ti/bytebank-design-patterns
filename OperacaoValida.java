package br.com.bytebank.validation;

public class OperacaoValida extends Validador {
    @Override
    protected String verificar(String operacao, int valor, int saldo) {
        if (!"DEPOSITAR".equals(operacao) && !"SACAR".equals(operacao)) {
            return "ERRO: OPERACAO INVALIDA";
        }
        return null;
    }
}
