package com.salesianostriana.dam.miniproyecto.dto.route;

import com.salesianostriana.dam.miniproyecto.models.POI;
import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CreateRouteDto {

    private String nombre;

    private List<POI> steps;

}
