package org.sebas.optional.ejemplo;

import org.sebas.optional.ejemplo.models.Computador;
import org.sebas.optional.ejemplo.models.Fabricante;
import org.sebas.optional.ejemplo.models.Procesador;
import org.sebas.optional.ejemplo.models.repositorio.ComputadorRepository;
import org.sebas.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repo = new ComputadorRepository();

        /*  TODO: Nivel 1
            Fabricante fab = repo.filtrar("rog")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .orElseThrow();
             System.out.println("Fabricante = " + fab.getNombre());
         */

        /*  TODO: Nivel 2
            String fab = repo.filtrar("rog")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .map(Fabricante::getNombre)
                .orElse("Desconocido");
            System.out.println("Fabricante = " + fab);
         */

        /* TODO: Nivel 3
           String fab = repo.filtrar("rog")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .filter(f -> f.getNombre().equalsIgnoreCase("Intel"))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");
            System.out.println("Fabricante = " + fab);
         */

        /*
            TODO: flatMap
            Por ejemplo tenemos varios optional anidados
            Optional<Optional<Procesador>>, lo que hace el flatMap
            tambien regresa un nuevo tipo de dato pero aplana todos
            los Optional anidados y solo deja 1
         */

        String fab = repo.filtrar("rog")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(f -> f.getNombre().equalsIgnoreCase("Intel"))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");
        System.out.println("Fabricante = " + fab);


    }
}
