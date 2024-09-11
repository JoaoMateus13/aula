package com.curso.aula.dto;

import com.curso.aula.entities.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.beans.XMLEncoder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracters")
    private String name;
    @NotBlank
    @Size(min = 10, message = "Precisa ter mais de 10 caracters")
    private String description;
    @Positive(message = "O valor deve ser positivo")
    private Double price;
    private String imgUrl;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
    }




}
