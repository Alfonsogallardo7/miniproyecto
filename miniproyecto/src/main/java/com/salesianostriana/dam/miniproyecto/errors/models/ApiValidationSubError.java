package com.salesianostriana.dam.miniproyecto.errors.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ApiValidationSubError extends ApiSubError{

    private String objeto, campo, mensaje;
    private Object valorRechazado;
}
