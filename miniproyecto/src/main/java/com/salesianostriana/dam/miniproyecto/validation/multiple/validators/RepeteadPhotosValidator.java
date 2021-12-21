package com.salesianostriana.dam.miniproyecto.validation.multiple.validators;

import com.salesianostriana.dam.miniproyecto.validation.multiple.anotation.RepeatedPhotos;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RepeteadPhotosValidator implements ConstraintValidator<RepeatedPhotos, Object> {


    String[] photos;

    @Override
    public void initialize(RepeatedPhotos constraintAnnotation) {
        this.photos = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        for(int i = 0; i< photos.length; i++) {
            Object field = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photos[i]);
            for (int j = i + 1; j < photos.length; j++) {
                Object field2 = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photos[j]);
                if (field == field2) {
                    return true;
                }
            }
        }
        return false;
    }
}
