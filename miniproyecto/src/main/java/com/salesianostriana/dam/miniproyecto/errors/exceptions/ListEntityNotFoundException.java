package com.salesianostriana.dam.miniproyecto.errors.exceptions;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException (Class clazz) {
        super(String.format("No se puede encontrar elementos de tipo %s ", clazz.getName()));
    }
}
