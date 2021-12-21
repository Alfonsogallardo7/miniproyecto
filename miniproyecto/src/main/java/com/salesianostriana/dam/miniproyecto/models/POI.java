package com.salesianostriana.dam.miniproyecto.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class POI implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String location;

    @Lob
    private String description;

    private LocalDate date;

    private String coverPhoto;

    private String photo2;

    private String photo3;

    @ManyToOne
    @JoinColumn(name = "category", foreignKey = @ForeignKey(name = "FK_POI_CATEGORY"))
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Route> route = new ArrayList<>();


    public POI(String nombre, String location, String description, LocalDate date, String coverPhoto, String photo2, String photo3) {
        this.nombre = nombre;
        this.location = location;
        this.description = description;
        this.date = date;
        this.coverPhoto = coverPhoto;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }

    public POI(String nombre, String location, String description, LocalDate date, String coverPhoto, String photo2, String photo3, Category category, List<Route> route) {
        this.nombre = nombre;
        this.location = location;
        this.description = description;
        this.date = date;
        this.coverPhoto = coverPhoto;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.category = category;
        this.route = route;
    }
}
