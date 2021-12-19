package com.salesianostriana.dam.miniproyecto.repository;

import com.salesianostriana.dam.miniproyecto.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
