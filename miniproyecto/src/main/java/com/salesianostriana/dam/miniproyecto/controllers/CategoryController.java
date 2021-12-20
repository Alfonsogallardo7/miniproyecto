package com.salesianostriana.dam.miniproyecto.controllers;


import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/")
    public List<Category> findAll () {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findById (Long id) {
        return service.findById(id);
    }

}
