package org.sebas.optional.ejemplo.models.repositorio;

import org.sebas.optional.ejemplo.models.Computador;
import org.sebas.optional.ejemplo.models.Fabricante;
import org.sebas.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepository implements Repositorio<Computador> {

    private List<Computador> dataSource;

    public ComputadorRepository() {
        dataSource = new ArrayList<>();

        Procesador proc = new Procesador("I9-9880H", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(proc);
        dataSource.add(asus);

        dataSource.add(new Computador("Macbook Pro", "MVK2"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource
                .stream()
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();

        /* TODO: Mi Solucion
           Computador c = dataSource.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(new Computador("Pc default","Model default"));
            return Optional.of(c);
         */

        /*  TODO: Maestro (1) solucion
            for(Computador c: dataSource){
                if(c.getNombre().equalsIgnoreCase(nombre)){
                    return Optional.of(c);
                }
            }
            return Optional.empty();
        */
    }

}
