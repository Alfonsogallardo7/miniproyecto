package com.salesianostriana.dam.miniproyecto.validation.simple.validators;

import com.salesianostriana.dam.miniproyecto.repository.RouteRepository;
import com.salesianostriana.dam.miniproyecto.validation.simple.anotations.RouteUnique;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class RouteUniqueValidator implements ConstraintValidator<RouteUnique, String> {

    private final RouteRepository repository;

    @Override
    public void initialize(RouteUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

    /*//Este sería el método que deberíamos usar pero me dá error de compilación, por culpa
    //del método existsByName()
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(s);
    }*/
}
