package com.salesianostriana.dam.miniproyecto;

import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainPrueba {
    private final CategoryService service;

    @PostConstruct
    public void prueba () {
        Category categoria1 = Category.builder()
                .nombre("La categoria")
                .build();
        service.save(categoria1);
    }


}
