package br.com.bytebank.validation;

public class ValorPositivo extends Validador {
    @Override
    protected String verificar(String operacao, int valor, int saldo) {
        if (valor <= 0) {
            return "ERRO: VALOR INVALIDO";
        }
        return null;
    }
}
