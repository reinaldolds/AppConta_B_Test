package org.contabancotest.com;

public class AccountService {

    public void deposit(Account account, double amount) {
        if (account == null)
            throw new IllegalArgumentException("Conta é obrigatória");
        if (amount <= 0)
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero");

        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(Account account, double amount) throws InsufficientFundsException {
        if (account == null)
            throw new IllegalArgumentException("Conta é obrigatória");
        if (amount <= 0)
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero");
        if (account.getBalance() < amount)
            throw new InsufficientFundsException("Saldo insuficiente");

        account.setBalance(account.getBalance() - amount);
    }

    public void transfer(Account from, Account to, double amount) throws InsufficientFundsException {
        if (from == null || to == null)
            throw new IllegalArgumentException("Contas são obrigatórias");
        if (from == to)
            throw new IllegalArgumentException("Não é possível transferir para a mesma conta");

        withdraw(from, amount);
        deposit(to, amount);
    }
}
