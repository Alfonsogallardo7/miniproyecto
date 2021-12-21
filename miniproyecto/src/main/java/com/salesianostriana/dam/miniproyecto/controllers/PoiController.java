package com.salesianostriana.dam.miniproyecto.controllers;

import com.salesianostriana.dam.miniproyecto.dto.poi.CreatePoiDto;
import com.salesianostriana.dam.miniproyecto.models.POI;
import com.salesianostriana.dam.miniproyecto.service.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class PoiController {

    private final PoiService service;

    @GetMapping("/")
    public List<POI> findAll () {return service.findAll();}

    @GetMapping("/{id}")
    public POI findById (@PathVariable @Min(value = 0, message = "El identificador no puede ser negativo") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<POI> create (@Valid @RequestBody CreatePoiDto poi) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save1(poi));
    }

    @PutMapping("/{id}")
    public POI edit (@Valid @RequestBody CreatePoiDto poi, @PathVariable @Min(value = 0, message = "El identificador no puede ser negativo") Long id ) {
        return service.edit(id, poi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
