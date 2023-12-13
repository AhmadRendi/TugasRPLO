package com.example.tugasrplo.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

}
