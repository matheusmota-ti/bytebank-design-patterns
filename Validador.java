package br.com.bytebank.validation;

public abstract class Validador {
    private Validador proximo;

    public Validador setProximo(Validador proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public String validar(String operacao, int valor, int saldo) {
        String erro = verificar(operacao, valor, saldo);
        if (erro != null) {
            return erro;
        }
        return proximo == null ? null : proximo.validar(operacao, valor, saldo);
    }

    protected abstract String verificar(String operacao, int valor, int saldo);
}
