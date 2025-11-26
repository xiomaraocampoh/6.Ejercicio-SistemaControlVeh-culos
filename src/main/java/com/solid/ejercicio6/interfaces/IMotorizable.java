package com.solid.ejercicio6.interfaces;

// [ISP]
// Creamos una interfaz ESPECÍFICA solo para cosas con motor.
// Así no obligamos a la bicicleta a implementar métodos que no necesita.

public interface IMotorizable {
    void encenderMotor();
    void apagarMotor();
}