package org.sebas.optional.ejemplo;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class EjemploOptional {
    public static void main(String[] args) {

        /*  TODO: Optional

            Evitar cualquiere tipo de Exception NullPointerException
            en tiempo de ejecucion

            Puede guardar un solo Objeto
            Optional<Tipo de dato a contener>

            Para crear un Optional solo se puede con metodos estaticos
            1. Optional.empty() = Por defecto vacio
            2. Optional.of(T value) = Recibe un valor por argumento, no acepta null
            3. Optional.ofNullable(T value) = Recibe un valor y acepta valor null
        */

        String nombre = "Sebastian";
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println("Si posee un valor o esta presente = "+opt.isPresent());
        if(opt.isPresent()){
            System.out.println("Hola (1) " + opt.get());
        }
        System.out.println("Esta vacio = " + opt.isEmpty());

        //Tambien podemos validar el isPresent(), con expresiones lambda
        opt.ifPresent( value -> System.out.println("Hola (2) " + value));
        
        //
        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println("\n****\nopt = " + opt);
        System.out.println("Si posee un valor o esta presente = "+opt.isPresent());
        System.out.println("Esta vacio = " + opt.isEmpty());
        //Si no esta presente no se ejecuta
        //opt.ifPresent( value -> System.out.println("Hola (3) " + value));

        //Esta desde la version 9
        //Si esta presente ejecuta 1 arguemento(Consumer), si no el 2 argumento(Runnable)
        opt.ifPresentOrElse( value -> System.out.println("Hola (3) " + value)
                , () -> System.out.println("No esta presente"));
    }
}
