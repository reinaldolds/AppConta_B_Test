package org.contabancotest.com;

public class Account {
    private final String accountNumber;
    private final String owner;
    private double balance;

    public Account(String accountNumber, String owner, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank())
            throw new IllegalArgumentException("Número da conta é obrigatório");
        if (owner == null || owner.isBlank())
            throw new IllegalArgumentException("Titular é obrigatório");
        if (initialBalance < 0)
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    void setBalance(double balance) {
        this.balance = balance;
    }
}

