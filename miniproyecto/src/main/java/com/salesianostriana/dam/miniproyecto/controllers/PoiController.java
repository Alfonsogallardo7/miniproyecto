package com.salesianostriana.dam.miniproyecto.controllers;

import com.salesianostriana.dam.miniproyecto.models.POI;
import com.salesianostriana.dam.miniproyecto.service.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class PoiController {

    private final PoiService service;

    @GetMapping("/")
    public List<POI> findAll () {return service.findAll();}

    @GetMapping("/{id}")
    public POI findById (Long id) {
        return service.findById(id);
    }
}
