package com.salesianostriana.dam.miniproyecto.validation.multiple.anotation;

import com.salesianostriana.dam.miniproyecto.validation.multiple.validators.RepeteadPhotosValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RepeteadPhotosValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatedPhotos {

    String message() default "No pueden se pueden repetir las fotos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fields();
}
