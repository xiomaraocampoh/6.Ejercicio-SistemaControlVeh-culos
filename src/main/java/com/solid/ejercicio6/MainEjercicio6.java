package com.solid.ejercicio6;

import com.solid.ejercicio6.model.Coche;
import com.solid.ejercicio6.repository.RepositorioParking;
import com.solid.ejercicio6.service.GestorIngreso;
import com.solid.ejercicio6.service.GestorEgreso;


public class MainEjercicio6 {
    public static void main(String[] args) {
        // 1. Instancia única del repositorio (La base de datos en memoria)
        RepositorioParking repoCentral = new RepositorioParking();

        // 2. Inyección con Polimorfismo
        // GestorIngreso pide un IGuardador -> repoCentral cumple ese rol
        GestorIngreso ingreso = new GestorIngreso(repoCentral);

        // GestorEgreso pide IBuscador e IEliminador -> repoCentral cumple ambos roles
        // Nota: Pasamos el MISMO objeto, pero tratado como interfaces distintas.
        GestorEgreso egreso = new GestorEgreso(repoCentral, repoCentral);

        // 3. Ejecución
        Coche coche = new Coche("XYZ-123");

        ingreso.procesarIngreso(coche); // OK
        egreso.procesarSalida("XYZ-123"); // OK
    }
}