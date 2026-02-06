package se.iths.martin.javaverktyglabb2.service;

import org.springframework.stereotype.Service;
import se.iths.martin.javaverktyglabb2.component.AccountComponent;
import se.iths.martin.javaverktyglabb2.exception.InsufficientFundsException;
import se.iths.martin.javaverktyglabb2.exception.InvalidAmountException;
import se.iths.martin.javaverktyglabb2.exception.MaxWithdrawalExceededException;

@Service
public class ATMService {
    private AccountComponent accountComponent;
    private static final int MAX_WITHDRAWAL = 1000;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit must be greater than 0");
        }
        accountComponent.deposit(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdraw must be greater than 0");
        }
        if (amount > MAX_WITHDRAWAL) {
            throw new MaxWithdrawalExceededException("Tried to withdraw too much");
        }
        if (amount > accountComponent.getBalance()) {
            throw new InsufficientFundsException("Not enough money in your balance");
        }
        accountComponent.withdraw(amount);
    }

    public int getBalance() {
        return accountComponent.getBalance();
    }

}
