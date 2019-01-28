package com.springvalidate;

public class NotAuthrized extends Exception {

    public NotAuthrized(String message){
        super(message);
    }
}
