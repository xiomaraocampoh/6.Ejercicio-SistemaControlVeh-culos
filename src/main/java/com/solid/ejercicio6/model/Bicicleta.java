package com.solid.ejercicio6.model;


import com.solid.ejercicio6.interfaces.IConducible;
import com.solid.ejercicio6.interfaces.IIdentificable;
import java.util.logging.Logger;

// Bicicleta solo implementa lo que necesita. No sabe nada de motores.
public class Bicicleta implements IIdentificable, IConducible {
    private static final Logger logger = Logger.getLogger(Bicicleta.class.getName());
    private final String serial;

    public Bicicleta(String serial) {
        this.serial = serial;
    }

    @Override
    public void conducir() {
        logger.info(() -> "Bici " + serial + ": Pedaleando...");
    }

    @Override
    public String getPlacaOIdentificador() {
        return "BICI-" + serial;
    }
}