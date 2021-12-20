package com.salesianostriana.dam.miniproyecto.dto.category;

import com.salesianostriana.dam.miniproyecto.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public Category createCategoryDtoToCategory (CreateCategoryDto dto) {
        return Category.builder()
                .nombre(dto.getNombre())
                .poi(dto.getPoi())
                .build();
    }

    public CreateCategoryDto createCategoryToCreateCategoryDto(Category category) {
        return CreateCategoryDto.builder()
                .nombre(category.getNombre())
                .poi(category.getPoi())
                .build();
    }
}
