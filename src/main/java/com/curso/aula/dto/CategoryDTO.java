package com.curso.aula.dto;

import com.curso.aula.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryDTO {

    private Long id;
    private String name;


    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
