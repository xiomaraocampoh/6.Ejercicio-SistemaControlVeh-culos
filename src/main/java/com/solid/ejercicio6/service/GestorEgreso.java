package com.solid.ejercicio6.service;

import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.repository.interfaces.IBuscador;
import com.solid.ejercicio6.repository.interfaces.IEliminador;

import java.util.logging.Logger;


public class GestorEgreso {
    private static final Logger logger = Logger.getLogger(GestorEgreso.class.getName());

    private final IBuscador buscador;
    private final IEliminador eliminador;

    // Inyectamos las capacidades específicas
    public GestorEgreso(IBuscador buscador, IEliminador eliminador) {
        this.buscador = buscador;
        this.eliminador = eliminador;
    }

    public void procesarSalida(String identificador) {
        // Usamos el rol de buscar
        var vehiculoOpt = buscador.buscarPorId(identificador);

        if (vehiculoOpt.isPresent()) {
            IIdentificable v = vehiculoOpt.get();
            // Usamos el rol de eliminar
            eliminador.eliminar(v);
            logger.info(() -> "Retirado: " + v.getPlacaOIdentificador());
        } else {
            logger.warning(() -> "No encontrado: %s".formatted(identificador));
        }
    }
}