package com.example.esp11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/welcome")
    public String welcome(){
        return "ESP11 BOMBEIROS SIGA SIGA";
    }
}
