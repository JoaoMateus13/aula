package com.curso.aula.services;

import com.curso.aula.entities.Role;
import com.curso.aula.entities.User;
import com.curso.aula.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import projection.UserDetailsProjection;

import java.util.List;

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

}
