package com.curso.aula.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "tb_order_item")
public class OrdemItem {
    

    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();

    @Setter
    @Getter
    private Integer quantity;

    @Setter
    @Getter
    private Double price;

    public OrdemItem() {
    }

    public OrdemItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

}
