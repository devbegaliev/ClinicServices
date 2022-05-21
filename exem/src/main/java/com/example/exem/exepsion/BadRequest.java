package com.example.exem.exepsion;

public class BadRequest extends RuntimeException{
    public BadRequest(String message){
        super(message);
    }
}
