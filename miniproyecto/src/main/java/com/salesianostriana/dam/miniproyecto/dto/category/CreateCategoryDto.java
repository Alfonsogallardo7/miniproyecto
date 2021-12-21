package com.salesianostriana.dam.miniproyecto.dto.category;

import com.salesianostriana.dam.miniproyecto.models.POI;
import com.salesianostriana.dam.miniproyecto.validation.simple.anotations.CategoryUnique;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CreateCategoryDto {

    @NotNull(message = "{category.nombre.null}")
    @NotBlank(message = "{category.nombre.empty}")
    @CategoryUnique
    private String nombre;

    private List<POI> poi;
}
