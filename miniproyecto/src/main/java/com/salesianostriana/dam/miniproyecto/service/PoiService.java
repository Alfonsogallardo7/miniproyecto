package com.salesianostriana.dam.miniproyecto.service;

import com.salesianostriana.dam.miniproyecto.dto.poi.CreatePoiDto;
import com.salesianostriana.dam.miniproyecto.dto.poi.PoiDtoConverter;
import com.salesianostriana.dam.miniproyecto.errors.exceptions.ListEntityNotFoundException;
import com.salesianostriana.dam.miniproyecto.errors.exceptions.SingleEntityNotFoundException;
import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.models.POI;
import com.salesianostriana.dam.miniproyecto.models.Route;
import com.salesianostriana.dam.miniproyecto.repository.CategoryRepository;
import com.salesianostriana.dam.miniproyecto.repository.POIRepository;
import com.salesianostriana.dam.miniproyecto.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PoiService {

    private final POIRepository repository;
    private final PoiDtoConverter dtoConverter;
    private final CategoryRepository categoryRepository;
    private final RouteRepository routeRepository;

    public List<POI> findAll() {
        List<POI> result = repository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        }else {
            return result;
        }
    }

    public POI save1 (CreatePoiDto dto) {
        return repository.save(dtoConverter.CreatePoiDtoToPoi(dto));
    }
    public POI save (POI poi) {
        return repository.save(poi);
    }

    public POI findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public POI edit (Long id, CreatePoiDto dto) {
        return repository.findById(id).map(e -> {
                    e.setNombre(dto.getNombre());
                    e.setDate(dto.getDate());
                    e.setLocation(dto.getLocation());
                    e.setCategory(dto.getCategory());
                    e.setCoverPhoto(dto.getCoverPhoto());
                    e.setDescription(dto.getDescripcion());
                    e.setPhoto2(dto.getPhoto2());
                    e.setPhoto3(dto.getPhoto3());
                    e.setRoute(dto.getRoute());
                    repository.save(e);
                    return e;
                })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }



    public void deleteById (Long id) {
        Optional<POI> poi = repository.findById(id);
        if (poi.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            List<Category> categories = categoryRepository.todosPoiCategorias(id);
            categories.forEach(p -> {
                p.setPoi(null);

                categoryRepository.save(p);
            });

            List<Route> routes = routeRepository.todosRoutePoi(id);
            routes.forEach(p-> {
                p.setSteps(null);

                routeRepository.save(p);
            });
        }
    }
}
