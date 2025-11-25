package com.solid.ejercicio6;
import java.util.logging.Logger;

// Clase Coche: Es un Vehículo Y tiene Motor. Implementa ambas interfaces.

public class Coche implements IVehiculo, IMotorizable {
    private String placa;
    Logger logger = Logger.getLogger(getClass().getName());

    public Coche(String placa) {
        this.placa = placa;
    }

    // [SRP] Esta clase solo sabe ser un coche.

    @Override
    public void encenderMotor() {
        System.out.println("Coche " + placa + ": Motor encendido.");
    }

    @Override
    public void conducir() {
        // Lógica específica de conducir un coche
        System.out.println("Coche " + placa + ": Conduciendo por carretera.");
    }

    @Override
    public String getPlacaOIdentificador() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
