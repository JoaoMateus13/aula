package com.curso.aula.controllers;

import com.curso.aula.dto.UserDTO;
import com.curso.aula.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> me() {
        UserDTO dto = userService.getMeUser();

        return ResponseEntity.ok(dto);
    }



}
