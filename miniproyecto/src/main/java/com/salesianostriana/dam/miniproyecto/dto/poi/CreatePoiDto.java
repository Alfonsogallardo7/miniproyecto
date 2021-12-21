package com.salesianostriana.dam.miniproyecto.dto.poi;

import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.models.Route;
import com.salesianostriana.dam.miniproyecto.validation.multiple.anotation.RepeatedPhotos;
import com.salesianostriana.dam.miniproyecto.validation.simple.anotations.LocationFormatMatch;
import com.salesianostriana.dam.miniproyecto.validation.simple.anotations.PoiUnique;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@RepeatedPhotos(fields = {"coverPhoto", "photo2", "photo3"})
public class CreatePoiDto {

    @NotBlank(message = "{category.nombre.empty}")
    @PoiUnique
    private String nombre;

    @LocationFormatMatch
    private String location;

    private String descripcion;

    private LocalDate date = LocalDate.now();

    @URL(message = "{poi.coverPhoto.URL}")
    @NotBlank(message = "{poi.coverPhoto.blank}")
    private String coverPhoto;

    private String photo2;

    private String photo3;

    private Category category;

    private List<Route> route;
}
