package com.curso.aula.services;

import com.curso.aula.dto.CategoryDTO;
import com.curso.aula.dto.ProductMinDTO;
import com.curso.aula.dto.carrinho.OrdemItemDTO;
import com.curso.aula.dto.carrinho.OrderDTO;
import com.curso.aula.entities.*;
import com.curso.aula.repositories.CategoryRepository;
import com.curso.aula.repositories.OrdemItemRepository;
import com.curso.aula.repositories.OrderRepository;
import com.curso.aula.repositories.ProductRepository;
import com.curso.aula.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findByAll() {
        List<Category> result = categoryRepository.findAll();
        return result.stream().map(CategoryDTO::new).toList();
    }
}
