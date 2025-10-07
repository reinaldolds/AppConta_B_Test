// src/main/java/org/contabancotest/com/model/ContaBancaria.java
package org.contabancotest.com.model;

public class ContaBancaria {
    private final String titular;
    private double saldo;
    private final String numeroConta;
    private static int contadorContas = 1;

    public ContaBancaria(String titular) {
        this(titular, 0.0);
    }

    public ContaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Titular não pode ser vazio");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }

        this.titular = titular;
        this.saldo = saldoInicial;
        this.numeroConta = String.format("%06d", contadorContas++);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente para saque");
        }
        this.saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String toString() {
        return String.format("Conta %s - Titular: %s - Saldo: R$ %.2f",
                numeroConta, titular, saldo);
    }
}