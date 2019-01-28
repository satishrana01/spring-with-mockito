package com.springvalidate.service;


import com.google.common.base.Predicate;
import com.springvalidate.NotAuthrized;
import com.springvalidate.model.Account;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Validated
public interface AuthorisationService {

    Account authorise( @NotEmpty String accountNumber, @NotNull Predicate<Account> predicate )
            throws NotAuthrized;
}
