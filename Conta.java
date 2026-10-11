package br.com.bytebank.model;

public class Conta {
    private int saldo;

    public Conta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int valor) {
        saldo += valor;
    }

    public void sacar(int valor) {
        saldo -= valor;
    }
}
