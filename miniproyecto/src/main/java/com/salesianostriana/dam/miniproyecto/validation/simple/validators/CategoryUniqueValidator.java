package com.salesianostriana.dam.miniproyecto.validation.simple.validators;

import com.salesianostriana.dam.miniproyecto.repository.CategoryRepository;
import com.salesianostriana.dam.miniproyecto.validation.simple.anotations.CategoryUnique;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CategoryUniqueValidator implements ConstraintValidator<CategoryUnique, String> {

    private final CategoryRepository repository;

    @Override
    public void initialize(CategoryUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

    //Este sería el método que deberíamos usar pero me dá error de compilación, por culpa
    //del método existsByName()
   /* @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(s);
    } */
}
