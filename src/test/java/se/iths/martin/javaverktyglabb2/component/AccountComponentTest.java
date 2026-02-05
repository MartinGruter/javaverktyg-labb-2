package se.iths.martin.javaverktyglabb2.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {
    @Test
    public void testWithdraw() {
        //Arrange
        AccountComponent accountComponent = new AccountComponent();
        accountComponent.deposit(500);
//        accountComponent.setWithdrawAmount(200);

        //Act
        int result = accountComponent.getBalance();

        //Assert
        assertEquals(500, result);
    }


}
