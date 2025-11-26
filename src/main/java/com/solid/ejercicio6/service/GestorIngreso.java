package com.solid.ejercicio6.service;

import com.solid.ejercicio6.interfaces.IConducible;
import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.interfaces.IMotorizable;
import com.solid.ejercicio6.repository.interfaces.IGuardador;

import java.util.logging.Logger;

public class GestorIngreso {
    private static final Logger logger = Logger.getLogger(GestorIngreso.class.getName());
    private final IGuardador guardador;

    public GestorIngreso(IGuardador guardador) {
        this.guardador = guardador;
    }

    public void procesarIngreso(IIdentificable vehiculo) {
        if (vehiculo == null) return;

        logger.info(">>> INICIANDO PROCESO DE INGRESO <<<");

        // 1. El vehículo llega conduciendo hasta la plaza
        if (vehiculo instanceof IConducible conducible) {
            conducible.conducir();
        }

        // 2. Si tiene motor, DEBE apagarlo antes de bajar
        if (vehiculo instanceof IMotorizable motorizable) {
            motorizable.apagarMotor();
        } else {
            logger.info(" -> (Vehículo estacionado en silencio)");
        }

        // 3. Se guarda en el sistema
        guardador.guardar(vehiculo);
        logger.info(() -> "Vehículo estacionado correctamente: " + vehiculo.getPlacaOIdentificador());
    }
}