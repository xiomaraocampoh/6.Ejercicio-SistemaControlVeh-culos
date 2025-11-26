package com.solid.ejercicio6.model;

import com.solid.ejercicio6.interfaces.IConducible;
import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.interfaces.IMotorizable;

import java.util.logging.Logger;

public class Motocicleta implements IIdentificable, IConducible, IMotorizable {
    private static final Logger logger = Logger.getLogger(Motocicleta.class.getName());
    private final String placa;

    public Motocicleta(String placa) {
        this.placa = placa;
    }

    @Override
    public void encenderMotor() {
        logger.info(() -> "Moto " + placa + ": Motor encendido.");
    }

    @Override
    public void conducir() {
        logger.info(() -> "Moto " + placa + ": En movimiento.");
    }

    @Override
    public String getPlacaOIdentificador() {
        return placa;
    }
}