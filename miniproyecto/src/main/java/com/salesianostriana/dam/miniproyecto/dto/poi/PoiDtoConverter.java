package com.salesianostriana.dam.miniproyecto.dto.poi;

import com.salesianostriana.dam.miniproyecto.models.POI;
import org.springframework.stereotype.Component;

@Component
public class PoiDtoConverter {

    public POI CreatePoiDtoToPoi (CreatePoiDto dto) {
        return POI.builder()
                .nombre(dto.getNombre())
                .category(dto.getCategory())
                .coverPhoto(dto.getCoverPhoto())
                .date(dto.getDate())
                .description(dto.getDescripcion())
                .location(dto.getLocation())
                .coverPhoto(dto.getCoverPhoto())
                .photo2(dto.getPhoto2())
                .photo3(dto.getPhoto3())
                .build();
    }

    public CreatePoiDto CreatePoiToPoiDto(POI poi) {
        return CreatePoiDto.builder()
                .nombre(poi.getNombre())
                .category(poi.getCategory())
                .coverPhoto(poi.getCoverPhoto())
                .date(poi.getDate())
                .descripcion(poi.getDescription())
                .location(poi.getLocation())
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .build();
    }
}
