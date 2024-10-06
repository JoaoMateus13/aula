package com.curso.aula.services;

import com.curso.aula.entities.Role;
import com.curso.aula.entities.User;
import com.curso.aula.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userId){
        User me = userService.authenticate();

        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)){
            throw new ForbiddenException("acesso negado");
        }



    }
}
