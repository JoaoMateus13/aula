package com.curso.aula.controllers;


import com.curso.aula.dto.CategoryDTO;
import com.curso.aula.dto.ProductDTO;
import com.curso.aula.dto.ProductMinDTO;
import com.curso.aula.services.CategoryService;
import com.curso.aula.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){

        List<CategoryDTO> result = categoryService.findByAll();

        return ResponseEntity.ok(result);
    }
}
