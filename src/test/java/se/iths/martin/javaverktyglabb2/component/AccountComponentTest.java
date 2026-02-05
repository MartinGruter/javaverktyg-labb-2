package se.iths.martin.javaverktyglabb2.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {
    private AccountComponent accountComponent;

    @BeforeEach
    public void setup() {
        accountComponent = new AccountComponent();
    }


    @Test
    public void testDeposit() {
        //Arrange
        //AccountComponent accountComponent = new AccountComponent();
        //Act
        accountComponent.deposit(500);
        int result = accountComponent.getBalance();

        //Assert
        assertEquals(500, result);
    }

    @Test
    public void testWithdraw() {
        accountComponent.withdraw(100);

        int result = accountComponent.getBalance();

        assertEquals(-100, result);

    }

    @Test
    public void testDepositAndWithdraw() {
        //Arrange
        accountComponent.deposit(500);
        accountComponent.withdraw(200);

        //Act
        int result = accountComponent.getBalance();

        //Assert
        assertEquals(300, result);
    }

    @Test
    public void testBalanceIsZero() {
        assertEquals(0, accountComponent.getBalance());
    }


}
