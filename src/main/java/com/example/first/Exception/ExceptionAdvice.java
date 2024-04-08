package com.example.first.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> resourceNotFoundException(ResourceNotFoundException e) {
        Map<String, String> map = new HashMap<>();
        map.put("message", e.getMessage());
        return ResponseEntity.status(404).body(map);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> exceptionHandler(BindingResult result){
        Map<String, String> map = new HashMap<>();
        result.getAllErrors().forEach(error -> {
            String key = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            map.put(key, message);
        });

        return ResponseEntity.status(400).body(map);
    }
}
