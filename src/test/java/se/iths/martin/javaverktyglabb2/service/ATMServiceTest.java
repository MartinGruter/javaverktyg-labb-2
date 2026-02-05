package se.iths.martin.javaverktyglabb2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.martin.javaverktyglabb2.component.AccountComponent;
import se.iths.martin.javaverktyglabb2.exception.InsufficientFundsException;
import se.iths.martin.javaverktyglabb2.exception.InvalidAmountException;
import se.iths.martin.javaverktyglabb2.exception.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {
    @Mock
    private AccountComponent accountComponent;
    @InjectMocks
    private ATMService atmService;

    @Test
    public void testInvalidAmountExceptionWithDepositMethod() {
        assertThrows(InvalidAmountException.class, () -> {
            atmService.deposit(0);
        });
        assertThrows(InvalidAmountException.class, () -> {
            atmService.deposit(-100);
        });
    }

    @Test
    public void testInvalidAmountExceptionWithWithdrawMethod() {
        assertThrows(InvalidAmountException.class, () -> {
            atmService.withdraw(0);
        });
        assertThrows(InvalidAmountException.class, () -> {
            atmService.withdraw(-100);
        });
    }

    @Test
    public void testMaxWithdrawalExceededExceptionWithWithdrawMethod() {
        assertThrows(MaxWithdrawalExceededException.class, () -> {
            atmService.withdraw(1100);
        });
    }

    @Test
    public void testInsufficientFundsExceptionWithWithdrawMethod() {
        assertThrows(InsufficientFundsException.class, () -> {
            atmService.withdraw(500);
        });
    }

    @Test
    void testCorrectDeposit() {
        atmService.deposit(500);
        verify(accountComponent).deposit(500);
    }


    @Test
    public void testCorrectWithdraw() {
        when(accountComponent.getBalance()).thenReturn(500);
        atmService.withdraw(200);
        verify(accountComponent).withdraw(200);
    }

    @Test
    public void testGetBalance() {
        when(accountComponent.getBalance()).thenReturn(500);
        int balance = atmService.getBalance();
        verify(accountComponent).getBalance();
        assertEquals(500, balance);
    }
}
