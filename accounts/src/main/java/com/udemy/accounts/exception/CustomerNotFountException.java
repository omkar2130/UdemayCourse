package com.udemy.accounts.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFountException extends RuntimeException {

    public CustomerNotFountException(String resourceName, String filedName, String filedValue){
        super(String.format("%s not found with the given input data %s %s",resourceName,filedName,filedValue));
    }

}
