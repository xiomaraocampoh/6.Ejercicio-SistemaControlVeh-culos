package com.solid.ejercicio6;

public class MainEjercicio6 {
    public static void main(String[] args) {
        // 1. Creamos el sistema de control
        Estacionamiento parking = new Estacionamiento();

        // 2. Creamos los vehículos
        // Nota como Coche y Bici son diferentes pero conviven
        Coche miCoche = new Coche("ABC-123");
        Bicicleta miBici = new Bicicleta("BMX-001");
        Motocicleta miMoto = new Motocicleta("YAM-999");

        // 3. Probamos el comportamiento específico (Motor)
        // La bici NO tiene acceso a encenderMotor(), lo cual es correcto lógicamente.
        miCoche.encenderMotor();
        // miBici.encenderMotor(); // Esto daría error de compilación. ¡ISP funciona!

        // 4. Ingresamos todos al estacionamiento (DIP en acción)
        parking.aparcarVehiculo(miCoche);
        parking.aparcarVehiculo(miBici);
        parking.aparcarVehiculo(miMoto);

        // 5. Verificamos que todos respondan
        parking.realizarRondaDeVigilancia();
    }
}