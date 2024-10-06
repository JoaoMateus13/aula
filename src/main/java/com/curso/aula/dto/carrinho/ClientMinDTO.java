package com.curso.aula.dto.carrinho;

import com.curso.aula.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientMinDTO {

    private Long id;
    private String name;

    public ClientMinDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
