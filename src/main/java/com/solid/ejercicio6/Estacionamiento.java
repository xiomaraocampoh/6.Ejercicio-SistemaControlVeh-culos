package com.solid.ejercicio6;

import java.util.ArrayList;
import java.util.List;

// [SRP] Responsabilidad única: Gestionar el ingreso/egreso de vehículos.
class Estacionamiento {
    // [DIP - Dependency Inversion Principle]
    // Dependemos de la ABSTRACCIÓN (IVehiculo), no de clases concretas (Coche, Moto).
    // Esto permite que el estacionamiento acepte cualquier cosa que implemente IVehiculo.
    private List<IVehiculo> espaciosOcupados = new ArrayList<>();

    public void aparcarVehiculo(IVehiculo vehiculo) {
        // [OCP - Open/Closed Principle]
        // Si mañana inventan un "PatineteEléctrico", este método NO cambia. Funciona igual.
        espaciosOcupados.add(vehiculo);
        System.out.println("Estacionamiento: Ingresó vehículo " + vehiculo.getPlacaOIdentificador());

        // Verificación de tipo segura (opcional, para demostrar capacidades)
        if (vehiculo instanceof IMotorizable) {
            System.out.println("   -> Nota: Recordar apagar el motor.");
        }
    }

    public void realizarRondaDeVigilancia() {
        System.out.println("--- Ronda de Vigilancia ---");
        for (IVehiculo v : espaciosOcupados) {
            // [LSP - Liskov Substitution Principle]
            // Tratamos a todos por igual (Coches, Bicis) y ninguno rompe el código.
            v.conducir();
        }
    }
}