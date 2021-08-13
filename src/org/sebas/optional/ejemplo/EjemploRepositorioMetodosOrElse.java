package org.sebas.optional.ejemplo;

import org.sebas.optional.ejemplo.models.Computador;
import org.sebas.optional.ejemplo.models.repositorio.ComputadorRepository;
import org.sebas.optional.ejemplo.models.repositorio.Repositorio;

import java.util.Arrays;
import java.util.stream.Stream;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repo = new ComputadorRepository();

        /*  todo: orElse()
            Si no se encuentra devuelve un objeto del tipo indicado
            por defecto
         */
        //Computador computadorPorDefecto = new Computador("HP Omen","LA0001");
        Computador pc = repo.filtrar("asus rog").orElse(valorDefecto());
        System.out.println("pc= " + pc);



        /*  todo: orElseGet()
            No se pasa un objeto, si no una expresion lambda
         */
        pc = repo.filtrar("macbook").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
        System.out.println("pc = " + pc);

        /* todo: Diferencia orElse() && orElseGet()
           - En el orElse() -> Independiente si se encuentra o no
           el objeto de tipo Computador, va a ejecutar lo que se le pasen por
           argumento, como el metodo estatico valorDefecto(), aunque no retorna
           el objeto de Computador por defecto si muestare el System.out.println
           y se crea la instancia dejandolo en el limbo, sin utilizar

           Por lo tanto va a ocupar recursos, crear la instancia, por lo tanto es
           mas recomendable usar el todo: orElseGet()
        */

    }
    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto!!!");
        return new Computador("HP Omen","LA0001");
    }
}
