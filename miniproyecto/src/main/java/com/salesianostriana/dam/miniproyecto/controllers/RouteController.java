package com.salesianostriana.dam.miniproyecto.controllers;

import com.salesianostriana.dam.miniproyecto.dto.route.CreateRouteDto;
import com.salesianostriana.dam.miniproyecto.models.Route;
import com.salesianostriana.dam.miniproyecto.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    @GetMapping("/")
    public List<Route> findAll () {return service.findAll();}

    @GetMapping("{id}")
    public Route findById (@PathVariable @Min(value = 0, message = "El identificador no puede ser negativo") Long id) {
        return service.findById(id);}

    @PostMapping("/")
    public ResponseEntity<Route> create (@Valid @RequestBody CreateRouteDto route) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save1(route));
    }

    @PutMapping("/{id}")
    public Route edit (@Valid @RequestBody CreateRouteDto route, @PathVariable @Min(value = 0, message = "El identificador no puede ser negativo") Long id ) {
        return service.edit(id, route);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
