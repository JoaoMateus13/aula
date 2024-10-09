package com.curso.aula.controllers.sso;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class LoginOauth2Controller {

    @GetMapping()
    public String getHomePage() {
        return "index";
    }




}
