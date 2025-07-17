package com.udemy.accounts.exception;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException(String msg){
        super(msg);
    }

}
