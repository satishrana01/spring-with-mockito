package com.springvalidate.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public final class Account

{
    @NotNull
    @Valid
    private String accountNumber;

    @NotNull
    private String accountType;

    public Account(String accountNumber, String accountType) {
        super();
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
