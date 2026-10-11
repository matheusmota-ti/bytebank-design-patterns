package br.com.bytebank.validation;

public class SaldoSuficiente extends Validador {
    @Override
    protected String verificar(String operacao, int valor, int saldo) {
        if ("SACAR".equals(operacao) && valor > saldo) {
            return "ERRO: SALDO INSUFICIENTE";
        }
        return null;
    }
}
