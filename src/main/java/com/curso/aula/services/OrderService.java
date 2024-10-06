package com.curso.aula.services;

import com.curso.aula.dto.ProductDTO;
import com.curso.aula.dto.carrinho.OrderDTO;
import com.curso.aula.entities.Order;
import com.curso.aula.entities.Product;
import com.curso.aula.repositories.OrderRepository;
import com.curso.aula.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;



    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {

        Order order = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Order não encontrado!"));

        return new OrderDTO (order);

    }



}
