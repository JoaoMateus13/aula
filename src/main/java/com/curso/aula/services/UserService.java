package com.curso.aula.services;

import com.curso.aula.dto.UserDTO;
import com.curso.aula.entities.Role;
import com.curso.aula.entities.User;
import com.curso.aula.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curso.aula.projection.UserDetailsProjection;

import java.util.List;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> listUser = userRepository.searchUserAndRolesByEmail(username);

        if (listUser.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(listUser.get(0).getPassword());
        for (UserDetailsProjection userDetails : listUser) {
            user.addRole(new Role(userDetails.getRoleId(), userDetails.getAuthority()));

        }

        return user;
    }


    protected User authenticate() {

        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");

            return userRepository.findByEmail(username).get();

        }
        catch (Exception e) {
            throw new UsernameNotFoundException("Invalid Email");
        }


    }

    @Transactional(readOnly = true)
    public UserDTO getMeUser(){
        User user = authenticate();
        return new UserDTO(user);
    }

}
