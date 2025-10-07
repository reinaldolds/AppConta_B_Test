package org.contabancotest.com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void depositShouldIncreaseBalance() {
        Account acc = new Account("111", "Reinaldo", 100.0);
        AccountService service = new AccountService();
        service.deposit(acc, 50.0);
        assertEquals(150.0, acc.getBalance(), 0.0001);
    }

    @Test
    void depositZeroOrNegativeShouldThrow() {
        Account acc = new Account("111", "Reinaldo", 100.0);
        AccountService service = new AccountService();
        assertThrows(IllegalArgumentException.class, () -> service.deposit(acc, 0));
        assertThrows(IllegalArgumentException.class, () -> service.deposit(acc, -10));
    }

    @Test
    void withdrawShouldReduceBalance() throws InsufficientFundsException {
        Account acc = new Account("222", "Maria", 200.0);
        AccountService service = new AccountService();
        service.withdraw(acc, 50.0);
        assertEquals(150.0, acc.getBalance(), 0.0001);
    }

    @Test
    void withdrawInsufficientShouldThrow() {
        Account acc = new Account("333", "Carlos", 30.0);
        AccountService service = new AccountService();
        assertThrows(InsufficientFundsException.class, () -> service.withdraw(acc, 50.0));
    }

    @Test
    void transferShouldMoveMoneyBetweenAccounts() throws InsufficientFundsException {
        Account a = new Account("A1", "Ana", 100.0);
        Account b = new Account("B1", "Pedro", 20.0);
        AccountService service = new AccountService();
        service.transfer(a, b, 50.0);
        assertEquals(50.0, a.getBalance(), 0.0001);
        assertEquals(70.0, b.getBalance(), 0.0001);
    }
}
