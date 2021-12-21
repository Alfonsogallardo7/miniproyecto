package com.salesianostriana.dam.miniproyecto.repository;

import com.salesianostriana.dam.miniproyecto.models.Category;
import com.salesianostriana.dam.miniproyecto.models.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = """
            select
               *
            form Category where POI_id = :id
            """, nativeQuery = true)
    List<Category> todosPoiCategorias(@Param("id") Long id);


    @Query(value = """
            select
               *
            form POI where route_id = :id
            """, nativeQuery = true)
    List<POI> todosRoutePoi(@Param("id") Long id);

    //Da error al ejecutarlo
    // boolean existsByName(String name);

}
