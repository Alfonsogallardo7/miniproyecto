package com.salesianostriana.dam.miniproyecto.validation.simple.anotations;

import com.salesianostriana.dam.miniproyecto.validation.simple.validators.PoiUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PoiUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PoiUnique {
    String message() default "Ya existe un POI con ese nombre";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
