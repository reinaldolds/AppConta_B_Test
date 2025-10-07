// src/test/java/org/contabancotest/com/ContaBancariaTest.java
package org.contabancotest.com;

import org.contabancotest.com.model.ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {
    private ContaBancaria conta;

    @BeforeEach
    void setUp() {
        conta = new ContaBancaria("João Silva", 1000.0);
    }

    @Test
    @DisplayName("Deve criar conta com saldo inicial válido")
    void deveCriarContaComSaldoInicial() {
        assertEquals("João Silva", conta.getTitular());
        assertEquals(1000.0, conta.getSaldo());
        assertNotNull(conta.getNumeroConta());
    }

    @Test
    @DisplayName("Deve criar conta com saldo zero quando não especificado")
    void deveCriarContaComSaldoZero() {
        ContaBancaria novaConta = new ContaBancaria("Maria Santos");
        assertEquals(0.0, novaConta.getSaldo());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar conta com titular vazio")
    void deveLancarExcecaoComTitularVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria(""));
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar conta com saldo negativo")
    void deveLancarExcecaoComSaldoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria("Carlos", -100.0));
    }

    @Test
    @DisplayName("Deve permitir depósito com valor válido")
    void devePermitirDepositoValido() {
        conta.depositar(500.0);
        assertEquals(1500.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Deve rejeitar depósito com valor negativo")
    void deveRejeitarDepositoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> conta.depositar(-100.0));
    }

    @Test
    @DisplayName("Deve rejeitar depósito com valor zero")
    void deveRejeitarDepositoZero() {
        assertThrows(IllegalArgumentException.class,
                () -> conta.depositar(0.0));
    }

    @Test
    @DisplayName("Deve permitir saque com saldo suficiente")
    void devePermitirSaqueComSaldoSuficiente() {
        conta.sacar(300.0);
        assertEquals(700.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar sacar valor maior que saldo")
    void deveLancarExcecaoSaqueMaiorQueSaldo() {
        assertThrows(IllegalStateException.class,
                () -> conta.sacar(1500.0));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar sacar valor negativo")
    void deveLancarExcecaoSaqueNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> conta.sacar(-100.0));
    }

    @Test
    @DisplayName("Deve retornar saldo correto após operações")
    void deveRetornarSaldoCorreto() {
        conta.depositar(200.0);
        conta.sacar(100.0);
        assertEquals(1100.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Deve gerar número de conta único")
    void deveGerarNumeroContaUnico() {
        ContaBancaria conta1 = new ContaBancaria("Cliente 1");
        ContaBancaria conta2 = new ContaBancaria("Cliente 2");

        assertNotEquals(conta1.getNumeroConta(), conta2.getNumeroConta());
    }
}