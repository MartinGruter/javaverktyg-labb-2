package se.iths.martin.javaverktyglabb2.service;

import se.iths.martin.javaverktyglabb2.component.AccountComponent;

public class ATMService {
    private final AccountComponent accountComponent;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }
}
