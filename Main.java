package br.com.bytebank;

import br.com.bytebank.model.Conta;
import br.com.bytebank.operation.OperacaoBancaria;
import br.com.bytebank.operation.OperacaoFactory;
import br.com.bytebank.validation.OperacaoValida;
import br.com.bytebank.validation.SaldoSuficiente;
import br.com.bytebank.validation.Validador;
import br.com.bytebank.validation.ValorPositivo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String entrada = scanner.nextLine().trim();
        scanner.close();

        String[] partes = entrada.split("\\s+");
        if (partes.length != 3) {
            System.out.println("ERRO: OPERACAO INVALIDA");
            return;
        }

        String tipo = partes[0];
        int saldoInicial;
        int valor;

        try {
            saldoInicial = Integer.parseInt(partes[1]);
            valor = Integer.parseInt(partes[2]);
        } catch (NumberFormatException e) {
            System.out.println("ERRO: VALOR INVALIDO");
            return;
        }

        Conta conta = new Conta(saldoInicial);
        OperacaoBancaria operacao = OperacaoFactory.criar(tipo);

        Validador cadeia = new OperacaoValida();
        cadeia.setProximo(new ValorPositivo())
              .setProximo(new SaldoSuficiente());

        String erro = cadeia.validar(tipo, valor, conta.getSaldo());
        if (erro != null) {
            System.out.println(erro);
            return;
        }

        operacao.executar(conta, valor);
        System.out.println("OK " + conta.getSaldo());
    }
}
