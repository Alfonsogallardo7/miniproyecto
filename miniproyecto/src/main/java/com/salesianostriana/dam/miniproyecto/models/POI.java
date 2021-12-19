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
}
