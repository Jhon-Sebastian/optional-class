package org.sebas.optional.ejemplo.models.repositorio;

import org.sebas.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {

    Optional<T> filtrar(String nombre);

}
