package com.thehrdivision;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloRepository repository;

    @GetMapping
    public List<Hello> findHelloAsList() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Hello> postHello(@RequestBody Hello hello) {
        return new ResponseEntity<>(repository.save(hello), HttpStatus.CREATED);
    }
}
