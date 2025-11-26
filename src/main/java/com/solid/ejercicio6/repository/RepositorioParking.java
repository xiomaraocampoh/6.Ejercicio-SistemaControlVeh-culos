package com.solid.ejercicio6.repository;

import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.repository.interfaces.IBuscador;
import com.solid.ejercicio6.repository.interfaces.IEliminador;
import com.solid.ejercicio6.repository.interfaces.IGuardador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Implementa TODOS los roles, pero se entregará "por partes" a quien lo necesite.
public class RepositorioParking implements IGuardador, IEliminador, IBuscador {

    private final List<IIdentificable> vehiculos = new ArrayList<>();

    @Override
    public void guardar(IIdentificable vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    @Override
    public void eliminar(IIdentificable vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    @Override
    public Optional<IIdentificable> buscarPorId(String id) {
        return vehiculos.stream()
                .filter(v -> v.getPlacaOIdentificador().equals(id))
                .findFirst();
    }

}