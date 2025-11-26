package com.solid.ejercicio6.service;

import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.interfaces.IMotorizable;
import com.solid.ejercicio6.repository.interfaces.IGuardador;

import java.util.logging.Logger;


public class GestorIngreso {
    private static final Logger logger = Logger.getLogger(GestorIngreso.class.getName());

    // DIP + ISP: Dependemos de una interfaz estrecha
    private final IGuardador guardador;

    public GestorIngreso(IGuardador guardador) {
        this.guardador = guardador;
    }

    public void procesarIngreso(IIdentificable vehiculo) {
        if (vehiculo != null) {
            guardador.guardar(vehiculo); // Única acción permitida
            logger.info(() -> "Ingresado: " + vehiculo.getPlacaOIdentificador());

            if (vehiculo instanceof IMotorizable) {
                logger.info(" -> Recordatorio: Apagar motor.");
            }
        }
    }
}