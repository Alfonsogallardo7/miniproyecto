package com.salesianostriana.dam.miniproyecto.controllers;


import com.salesianostriana.dam.miniproyecto.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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
    public Category findById (@PathVariable @Min(value = 0, message = "El identificador no puede ser negativo") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Category> create (@Valid @RequestBody CreateCategoryDto category) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save1(category));
    }

    @PutMapping("/{id}")
    public Category edit (@Valid @RequestBody CreateCategoryDto category, @PathVariable @Min(value = 0, message = "El identificador no puede ser negativo") Long id) {
        return service.edit(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
