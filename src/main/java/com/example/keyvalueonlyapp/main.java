package com.example.keyvalueonlyapp;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class main {
    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") String id) {
        Response response = new Response();

        System.out.println(id);

        response.setData("OK");
        response.setSuccess(true);
        response.setMessage("Allowed");

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
