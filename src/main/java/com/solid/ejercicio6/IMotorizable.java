package com.solid.ejercicio6;

// [ISP]
// Creamos una interfaz ESPECÍFICA solo para cosas con motor.
// Así no obligamos a la bicicleta a implementar métodos que no necesita.
interface IMotorizable {
    void encenderMotor();
}