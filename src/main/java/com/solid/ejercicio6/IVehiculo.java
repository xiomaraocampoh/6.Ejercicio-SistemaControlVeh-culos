package com.solid.ejercicio6;

// [ISP - Interface Segregation Principle]
// Creamos una interfaz básica para CUALQUIER vehículo.
interface IVehiculo {
    String getPlacaOIdentificador();
    void conducir();
}