package test.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import teste.factories.AccountFactory;

public class AccountTests {

    @Test
    @DisplayName("Test deposit to Account")
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        //Padrão AAA - Arrange, Act, Assert

        //Arrange
        double amount = 200.00;
        double expectedValue = 196.00;
        Account acc = AccountFactory.buildEmptyAccount();

        //Act
        acc.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    @DisplayName("Test deposit negative value to Account")
    public void depositShouldDoNothingWhenNegativeAmount(){

        double amount = -200.00;
        double expectedValue = 100.00;
        Account acc = AccountFactory.buildAccount(expectedValue);

        acc.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance(){

        double expectedValue = 0.0;
        double initialBalance = 800.00;

        Account acc = AccountFactory.buildAccount(initialBalance);

        double result = acc.fullWithDraw();

        //Assert
        Assertions.assertTrue(expectedValue== acc.getBalance());
        Assertions.assertEquals(result, initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance(){

        double amount = 300.00;
        double initialBalance = 800.00;
        Account acc = AccountFactory.buildAccount(initialBalance);

        double expectedValue = initialBalance - amount;
        acc.withdraw(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance(){

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            double amount = 500.00;
            double initialBalance = 400.00;
            Account acc = AccountFactory.buildAccount(initialBalance);
            acc.withdraw(amount);
        });

    }


}
