package com.salesianostriana.dam.miniproyecto.validation.simple.anotations;

import com.salesianostriana.dam.miniproyecto.validation.simple.validators.RouteUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = RouteUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RouteUnique {

    String message() default "Ya existe una ruta con ese nombre";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
