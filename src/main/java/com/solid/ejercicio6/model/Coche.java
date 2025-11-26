package com.solid.ejercicio6.model;

import com.solid.ejercicio6.interfaces.IConducible;
import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.interfaces.IMotorizable;
import java.util.logging.Logger;


public class Coche implements IIdentificable, IConducible, IMotorizable {
    private static final Logger logger = Logger.getLogger(Coche.class.getName());
    private static final String TIPO = "Coche ";
    private final String placa;

    public Coche(String placa) {
        this.placa = placa;
    }

    @Override
    public void encenderMotor() {
        logger.info(() -> TIPO + placa + ": Motor encendido.");
    }

    @Override
    public void apagarMotor() {
        logger.info(() -> TIPO + placa + ": Shhh... Motor APAGADO.");
    }

    @Override
    public void conducir() {
        logger.info(() -> TIPO + placa + ": Moviéndose por el carril.");
    }

    @Override
    public String getPlacaOIdentificador() {
        return placa;
    }
}