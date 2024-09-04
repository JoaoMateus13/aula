package com.curso.aula.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrdemItemPK {


    @ManyToAny
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToAny
    @JoinColumn(name = "product_id")
    private Product product;
}
