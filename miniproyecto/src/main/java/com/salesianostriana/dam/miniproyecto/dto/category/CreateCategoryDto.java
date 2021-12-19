package com.salesianostriana.dam.miniproyecto.dto.category;

import com.salesianostriana.dam.miniproyecto.models.POI;
import lombok.*;

import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CreateCategoryDto {

    private String nombre;

    private List<POI> poi;
}
