package com.example.keyvalueonlyapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class main {

    @Value("${alowedId}")
    private String AllowedId;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") String id) {
        Response response = new Response();
        String allowedId = this.AllowedId;
        HashMap<String, Boolean> mappingSuccess = new HashMap<String, Boolean>() {{
            put(allowedId, true);
        }};

        String messageResps = id.equals(allowedId) ? "Allowed" : "Denied";
        Boolean successResps = mappingSuccess.get(id) != null;

        response.setData("OK");
        response.setSuccess(successResps);
        response.setMessage(messageResps);

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<Response> get() {
        Response response = new Response();

        response.setData("Hello");
        response.setSuccess(true);
        response.setMessage("");
        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
