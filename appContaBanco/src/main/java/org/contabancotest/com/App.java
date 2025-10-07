// src/main/java/org/contabancotest/com/App.java
package org.contabancotest.com;

import org.contabancotest.com.model.ContaBancaria;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = null;

        System.out.println("🏦 BEM-VINDO AO APP CONTA BANCO 🏦");

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta = criarConta(scanner);
                    break;
                case 2:
                    if (validarConta(conta)) realizarDeposito(conta, scanner);
                    break;
                case 3:
                    if (validarConta(conta)) realizarSaque(conta, scanner);
                    break;
                case 4:
                    if (validarConta(conta)) consultarSaldo(conta);
                    break;
                case 5:
                    System.out.println("👋 Obrigado por usar nosso banco!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. 📝 Criar Nova Conta");
        System.out.println("2. 💰 Realizar Depósito");
        System.out.println("3. 🏧 Realizar Saque");
        System.out.println("4. 📊 Consultar Saldo");
        System.out.println("5. 🚪 Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static ContaBancaria criarConta(Scanner scanner) {
        System.out.print("Digite o nome do titular: ");
        scanner.nextLine(); // Limpar buffer
        String titular = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria novaConta = new ContaBancaria(titular, saldoInicial);
        System.out.println("✅ Conta criada com sucesso!");
        System.out.println("Titular: " + novaConta.getTitular());
        System.out.println("Saldo inicial: R$ " + novaConta.getSaldo());

        return novaConta;
    }

    private static void realizarDeposito(ContaBancaria conta, Scanner scanner) {
        System.out.print("Digite o valor do depósito: ");
        double valor = scanner.nextDouble();

        try {
            conta.depositar(valor);
            System.out.println("✅ Depósito realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + conta.getSaldo());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }

    private static void realizarSaque(ContaBancaria conta, Scanner scanner) {
        System.out.print("Digite o valor do saque: ");
        double valor = scanner.nextDouble();

        try {
            conta.sacar(valor);
            System.out.println("✅ Saque realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + conta.getSaldo());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }

    private static void consultarSaldo(ContaBancaria conta) {
        System.out.println("\n=== EXTRATO ===");
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo atual: R$ " + conta.getSaldo());
    }

    private static boolean validarConta(ContaBancaria conta) {
        if (conta == null) {
            System.out.println("❌ Nenhuma conta criada. Por favor, crie uma conta primeiro.");
            return false;
        }
        return true;
    }
}