package com.salesianostriana.dam.miniproyecto.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Route implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToMany (mappedBy = "route", fetch = FetchType.EAGER)
    private List <POI> steps;
}
