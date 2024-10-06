package com.curso.aula.dto.carrinho;

import com.curso.aula.entities.OrdemItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrdemItemDTO {

    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    public OrdemItemDTO(OrdemItem ordemItem) {
        this.productId = ordemItem.getProduct().getId();
        this.name = ordemItem.getProduct().getName();
        this.price = ordemItem.getPrice();
        this.quantity = ordemItem.getQuantity();
    }

    public Double getSubTotal() {
        return this.price * this.quantity;
    }
}
