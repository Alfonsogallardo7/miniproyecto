package com.salesianostriana.dam.miniproyecto.service;

import com.salesianostriana.dam.miniproyecto.dto.route.CreateRouteDto;
import com.salesianostriana.dam.miniproyecto.dto.route.RouteDtoConverter;
import com.salesianostriana.dam.miniproyecto.errors.exceptions.ListEntityNotFoundException;
import com.salesianostriana.dam.miniproyecto.errors.exceptions.SingleEntityNotFoundException;
import com.salesianostriana.dam.miniproyecto.models.Route;
import com.salesianostriana.dam.miniproyecto.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repository;
    private final RouteDtoConverter dtoConverter;

    public List<Route> findAll() {
        List<Route> result = repository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);
        }else {
            return result;
        }
    }

    public Route save1 (CreateRouteDto dto) {
        return repository.save(dtoConverter.CreateRouteDtoToRoute(dto));
    }
    public Route save (Route route) {
        return repository.save(route);
    }

    public Route findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public Route edit (Long id, CreateRouteDto dto) {
        return repository.findById(id).map(e -> {
                    e.setNombre(dto.getNombre());
                    e.setSteps(dto.getSteps());
                    repository.save(e);
                    return e;
                })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }



    public void deleteById (Long id) {
        repository.findById(id)
                .orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), Route.class));
        if (repository.findById(id)!=null) {
            repository.deleteById(id);
        }
    }
}
