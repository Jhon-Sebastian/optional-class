package org.sebas.optional.ejemplo;

import org.sebas.optional.ejemplo.models.Computador;
import org.sebas.optional.ejemplo.models.repositorio.ComputadorRepository;
import org.sebas.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repo = new ComputadorRepository();
        repo.filtrar("asus rog5").ifPresentOrElse(System.out::println
                ,() -> System.out.println("No se encontro"));


        /*  todo: Lo que se hacia antes
            Optional<Computador> pc = repo.filtrar("asus rog");
            if(pc.isPresent()){
                System.out.println("pc = " + pc.get());
            }
        */

    }
}
