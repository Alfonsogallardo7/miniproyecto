package com.salesianostriana.dam.miniproyecto.repository;

import com.salesianostriana.dam.miniproyecto.models.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {

    @Query(value = """
            select
               *
            form POI where category_id = :id
            """, nativeQuery = true)
    List<POI> todasCategoriasPoi(@Param("id") Long id);

    //Da error al ejecutarlo
    // boolean existsByName(String name);
}

