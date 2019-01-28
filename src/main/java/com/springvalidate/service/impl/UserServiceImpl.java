package com.springvalidate.service.impl;

import com.springvalidate.NotAuthrized;
import com.springvalidate.model.Account;
import com.springvalidate.model.ServicePredicate;
import com.springvalidate.model.User;
import com.springvalidate.service.AuthorisationService;
import com.springvalidate.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AuthorisationService authorisationService;
    
    @Override
    public void valideUser(User user) throws NotAuthrized {
       
    Account account =     authorisationService.authorise("123456", new ServicePredicate("test"));
        
    if(account.getAccountType().equalsIgnoreCase("TEST")){
        throw new IllegalArgumentException();
    }
         if(user.getIsAdult().isEmpty()){
            
            throw new NotAuthrized("NotAuthrized");
        }
        
    }

      
}
