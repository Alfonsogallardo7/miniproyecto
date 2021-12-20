package com.salesianostriana.dam.miniproyecto.dto.poi;

import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.models.Route;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CreatePoiDto {

    private String nombre;

    private String location;

    private String descripcion;

    private LocalDate date;

    @URL
    private String coverPhoto;

    private String photo2;

    private String photo3;

    private Category category;

    private List<Route> route;
}
