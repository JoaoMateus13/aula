package com.curso.aula.dto.carrinho;

import com.curso.aula.entities.OrdemItem;
import com.curso.aula.entities.Order;
import com.curso.aula.entities.OrderStatus;
import com.curso.aula.entities.Payment;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDTO {

    private  Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientMinDTO client;
    private PaymentDTO payment;

    @NotEmpty(message = "O pedido deve ter pelo menos um item")
    private List<OrdemItemDTO> items = new ArrayList<>();

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.client = new ClientMinDTO(order.getClient());
        this.payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
        for (OrdemItem item : order.getItems()) {
            this.items.add(new OrdemItemDTO(item));
        }
    }


    public Double getTotal() {
        Double total = 0.0;

        for (OrdemItemDTO item : items) {
            total+= item.getSubTotal();
        }

        return total;
    }
}
