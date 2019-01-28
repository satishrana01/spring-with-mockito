package com.springvalidate.service.impl;

import com.google.common.base.Predicate;
import com.springvalidate.NotAuthrized;
import com.springvalidate.model.Account;
import com.springvalidate.service.AuthorisationService;

import org.springframework.stereotype.Service;

@Service
public class AuthorisationServiceImpl implements  AuthorisationService{

    @Override
    public Account authorise(String accountNumber, Predicate<Account> predicate) throws NotAuthrized {
        return null;
    }

}
