package com.salesianostriana.dam.miniproyecto.repository;

import com.salesianostriana.dam.miniproyecto.models.POI;
import com.salesianostriana.dam.miniproyecto.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {


    @Query(value = """
            select
               *
            form POI where route_id = :id
            """, nativeQuery = true)
    List<Route> todosRoutePoi(@Param("id") Long id);

    //Da error al ejecutarlo
    // boolean existsByName(String name);
}
