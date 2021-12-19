package com.salesianostriana.dam.miniproyecto.dto.route;

import com.salesianostriana.dam.miniproyecto.models.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {

    public Route CreateRouteDtoToRoute (CreateRouteDto dto) {
        return Route.builder()
                .nombre(dto.getNombre())
                .steps(dto.getSteps())
                .build();
    }

    public CreateRouteDto CreateRouteToRouteDto (Route route) {
        return CreateRouteDto.builder()
                .nombre(route.getNombre())
                .steps(route.getSteps())
                .build();
    }
}
