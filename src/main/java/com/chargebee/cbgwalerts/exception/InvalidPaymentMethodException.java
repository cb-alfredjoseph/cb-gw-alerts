package com.chargebee.cbgwalerts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPaymentMethodException extends RuntimeException{
    public InvalidPaymentMethodException(String message){
        super(message);
    }
}
