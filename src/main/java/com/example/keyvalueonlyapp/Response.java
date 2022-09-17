package com.example.keyvalueonlyapp;

import lombok.Data;

@Data
public class Response<T> {
    private boolean success;
    private String message;
    private T data;
}
