package com.springvalidate.model;

import com.google.common.base.Predicate;

public class ServicePredicate
    implements Predicate<Account>
{
    private final String service;

    public ServicePredicate( String service )
    {
        this.service = service;
    }

    @Override
    public boolean apply(Account input) {
       return false;
    }
    
  
}
