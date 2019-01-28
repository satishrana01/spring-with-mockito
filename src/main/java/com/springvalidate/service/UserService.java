package com.springvalidate.service;

import com.springvalidate.NotAuthrized;
import com.springvalidate.model.User;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Validated
public interface UserService {

      
    void valideUser(@NotNull @Valid User user) throws NotAuthrized;
  
    
}
