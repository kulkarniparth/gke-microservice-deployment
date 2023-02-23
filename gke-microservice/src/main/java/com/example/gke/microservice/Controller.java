package com.example.gke.microservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello "+name+" !!";
    }
}
