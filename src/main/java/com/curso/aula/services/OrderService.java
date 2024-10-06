package com.curso.aula.services;

import com.curso.aula.dto.ProductDTO;
import com.curso.aula.dto.carrinho.OrdemItemDTO;
import com.curso.aula.dto.carrinho.OrderDTO;
import com.curso.aula.entities.*;
import com.curso.aula.repositories.OrdemItemRepository;
import com.curso.aula.repositories.OrderRepository;
import com.curso.aula.repositories.ProductRepository;
import com.curso.aula.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdemItemRepository ordemItemRepository;

    @Autowired
    private UserService userService;



    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {

        Order order = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Order não encontrado!"));

        return new OrderDTO (order);

    }


    @Transactional
    public @Valid OrderDTO insert(OrderDTO dto) {

        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticate();
        order.setClient(user);

        for(OrdemItemDTO itemDTO: dto.getItems()){
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrdemItem ordemItem = new OrdemItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(ordemItem);
        }
        order = repository.save(order);
        ordemItemRepository.saveAll(order.getItems());
        return new OrderDTO (order);
    }
}
