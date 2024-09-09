package com.curso.aula.controllers;


import com.curso.aula.dto.ProductDTO;
import com.curso.aula.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    private ProductService service;


    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }


    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        return service.findByAll(pageable);
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO dto) {
        return service.insert(dto);
    }
}
