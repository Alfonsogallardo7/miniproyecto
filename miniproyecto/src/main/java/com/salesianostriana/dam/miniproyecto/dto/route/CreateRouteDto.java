package com.salesianostriana.dam.miniproyecto.dto.route;

import com.salesianostriana.dam.miniproyecto.models.POI;
import com.salesianostriana.dam.miniproyecto.validation.simple.anotations.RouteUnique;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CreateRouteDto {

    @NotNull(message = "{category.nombre.null}")
    @NotBlank(message = "{category.name.empty}")
    @RouteUnique
    private String nombre;

    private List<POI> steps;

}
