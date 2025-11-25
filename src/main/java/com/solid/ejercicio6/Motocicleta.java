package com.solid.ejercicio6;

class Motocicleta implements IVehiculo, IMotorizable {
    private String placa;

    public Motocicleta(String placa) {
        this.placa = placa;
    }

    @Override
    public void encenderMotor() {
        System.out.println("Moto " + placa + ": Motor encendido. Braap Braap.");
    }

    @Override
    public void conducir() {
        System.out.println("Moto " + placa + ": Moviéndose entre el tráfico.");
    }

    @Override
    public String getPlacaOIdentificador() {
        return placa;
    }
}