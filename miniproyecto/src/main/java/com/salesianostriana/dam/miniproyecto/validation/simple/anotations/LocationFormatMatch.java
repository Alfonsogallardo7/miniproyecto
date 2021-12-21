package com.salesianostriana.dam.miniproyecto.validation.simple.anotations;

import com.salesianostriana.dam.miniproyecto.validation.simple.validators.LocationMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LocationMatchValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocationFormatMatch {

    String message() default "El formato es incorrecto";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}

