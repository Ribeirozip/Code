package com.example.todolist.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/primeiraRota")
public class primeiracontrole {
    @GetMapping("/")
    public String primeiramensagem(){
        return "Hello word";
    }
}
