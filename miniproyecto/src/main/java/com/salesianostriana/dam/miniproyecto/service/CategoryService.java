package com.salesianostriana.dam.miniproyecto.service;

import com.salesianostriana.dam.miniproyecto.dto.category.CategoryDtoConverter;
import com.salesianostriana.dam.miniproyecto.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.miniproyecto.errors.exceptions.ListEntityNotFoundException;
import com.salesianostriana.dam.miniproyecto.errors.exceptions.SingleEntityNotFoundException;
import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.models.POI;
import com.salesianostriana.dam.miniproyecto.repository.CategoryRepository;
import com.salesianostriana.dam.miniproyecto.repository.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryDtoConverter dtoConverter;
    private final POIRepository poiRepository;

    public List<Category> findAll() {
        List<Category> result = repository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        }else {
            return result;
        }
    }

    public Category save1 (CreateCategoryDto dto) {
        return repository.save(dtoConverter.createCategoryDtoToCategory(dto));
    }
    public Category save (Category category) {
        return repository.save(category);
    }

    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    public Category edit (Long id, CreateCategoryDto dto) {
        return repository.findById(id).map(e -> {
            e.setNombre(dto.getNombre());
            e.setPoi(dto.getPoi());
            repository.save(e);
            return e;
        })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }





    public void deleteById (Long id) {
        Optional<Category> category = repository.findById(id);
        if (category.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            List<POI> poi = poiRepository.todasCategoriasPoi(id);
            poi.forEach(p -> {
                p.setCategory(null);

                poiRepository.save(p);
            });
        }
    }


}
