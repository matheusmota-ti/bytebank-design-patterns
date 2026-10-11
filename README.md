# ByteBank — Design Patterns em Java

Projeto de estudo de **Padrões de Projeto (Design Patterns)** usando Java puro, sem dependências externas.

## Objetivo

Simular operações bancárias de depósito e saque, aplicando padrões para separar responsabilidades e facilitar a manutenção.

## Padrões utilizados

- **Chain of Responsibility (Cadeia de Responsabilidade):** validações são executadas em sequência: operação permitida, valor positivo e saldo suficiente.
- **Strategy (Estratégia):** depósito e saque são comportamentos diferentes, implementados por classes próprias.
- **Simple Factory (Fábrica simples):** escolhe a estratégia correta a partir do texto informado.

## Requisitos

- JDK 17 ou superior
- Maven (opcional; pode executar diretamente pela IDE)

## Como executar

Na raiz do projeto, com Maven instalado:

```bash
mvn package
java -cp target/classes br.com.bytebank.Main
```

Digite uma operação em uma única linha, no formato:

```text
DEPOSITAR 100 50
```

Exemplos:

| Entrada | Saída |
|---|---|
| `DEPOSITAR 100 50` | `OK 150` |
| `SACAR 80 30` | `OK 50` |
| `SACAR 20 40` | `ERRO: SALDO INSUFICIENTE` |
| `PIX 100 10` | `ERRO: OPERACAO INVALIDA` |
| `DEPOSITAR 100 0` | `ERRO: VALOR INVALIDO` |

## Estrutura

```text
src/main/java/br/com/bytebank/
├── Main.java
├── model/
│   └── Conta.java
├── operation/
│   ├── OperacaoBancaria.java
│   ├── Deposito.java
│   ├── Saque.java
│   └── OperacaoFactory.java
└── validation/
    ├── Validador.java
    ├── OperacaoValida.java
    ├── ValorPositivo.java
    └── SaldoSuficiente.java
```

## Decisões de projeto

- Cada validador tem uma única responsabilidade.
- As validações são encadeadas; a primeira falha interrompe o processamento.
- A conta só tem seu saldo alterado quando a validação e a operação são concluídas com sucesso.
- A fábrica centraliza a seleção do tipo de operação.
- O projeto imprime somente a mensagem final para manter compatibilidade com o desafio.

## Próximas melhorias possíveis

- Criar testes automatizados com JUnit.
- Adicionar histórico de transações.
- Criar uma API REST usando Spring Boot.
