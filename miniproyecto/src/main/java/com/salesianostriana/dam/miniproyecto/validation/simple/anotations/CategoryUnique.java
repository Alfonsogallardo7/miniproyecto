package com.salesianostriana.dam.miniproyecto.validation.simple.anotations;

import com.salesianostriana.dam.miniproyecto.validation.simple.validators.CategoryUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = CategoryUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CategoryUnique {

    String message() default "Ya existe una categoría con ese nombre";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
