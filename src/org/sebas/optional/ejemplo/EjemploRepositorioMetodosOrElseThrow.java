package org.sebas.optional.ejemplo;

import org.sebas.optional.ejemplo.models.Computador;
import org.sebas.optional.ejemplo.models.repositorio.ComputadorRepository;
import org.sebas.optional.ejemplo.models.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repo = new ComputadorRepository();

        /* todo: orElseThrow()
           Si no encuentra el dato arroja la exception, se puede usar
           en casos especiales como, si no encuentra el valor no arroja un
           valor por defecto y si se quiere ser mas especifico arroja la
           exception que se desee

           Prancticamente es lo mismo que el get(), ya que este invita a
           invocar el valor pero si no existe arroja una exception, por lo
           cual es mejor el orElseThrow por tema de nomenclatura y va contra
           del patron de diseño Optional
        */

        Computador pc = repo.filtrar("asus rog").orElseThrow();
        System.out.println("pc= " + pc);

        /* todo: todo: orElseThrow( argumento )
           Podemos personalizar la exception
        */
        pc = repo.filtrar("asus rog").orElseThrow(IllegalStateException::new);
        System.out.println("pc= " + pc);

        // Ejemplo de filtrar con Optional
        // El Optional al igual que el Stream tambien tiene el filter, map
        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println(extension);
    }
}
