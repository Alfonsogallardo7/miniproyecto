package com.salesianostriana.dam.miniproyecto.service;

import com.salesianostriana.dam.miniproyecto.dto.category.CategoryDtoConverter;
import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private CategoryRepository repository;
    private CategoryDtoConverter dtoConverter;

    public List<Category> findAll() {
        List<Category> result = repository.findAll();

        if (result.isEmpty()) {
            throw
        }
    }
}
