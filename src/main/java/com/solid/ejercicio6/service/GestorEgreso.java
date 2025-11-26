package com.solid.ejercicio6.service;

import com.solid.ejercicio6.interfaces.IConducible;
import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.interfaces.IMotorizable;
import com.solid.ejercicio6.repository.interfaces.IBuscador;
import com.solid.ejercicio6.repository.interfaces.IEliminador;
import java.util.logging.Logger;


public class GestorEgreso {
    private static final Logger logger = Logger.getLogger(GestorEgreso.class.getName());
    private final IBuscador buscador;
    private final IEliminador eliminador;

    public GestorEgreso(IBuscador buscador, IEliminador eliminador) {
        this.buscador = buscador;
        this.eliminador = eliminador;
    }

    public void procesarSalida(String identificador) {
        var vehiculoOpt = buscador.buscarPorId(identificador);

        if (vehiculoOpt.isPresent()) {
            IIdentificable vehiculo = vehiculoOpt.get();
            logger.info(">>> INICIANDO PROCESO DE SALIDA <<<");

            // 1. Si tiene motor, hay que encenderlo primero
            if (vehiculo instanceof IMotorizable motorizable) {
                motorizable.encenderMotor();
            }
            // 2. El vehículo sale conduciendo
            if (vehiculo instanceof IConducible conducible) {
                conducible.conducir();
            }

            // 3. Se elimina del sistema (se levanta la barrera)
            eliminador.eliminar(vehiculo);
            logger.info(() -> "Salida completada: " + vehiculo.getPlacaOIdentificador());

        } else {
            logger.warning(() -> "No se encontró vehículo con id: %s".formatted(identificador));
        }
    }
}