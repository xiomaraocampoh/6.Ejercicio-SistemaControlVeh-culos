package com.solid.ejercicio6.repository.interfaces;

import com.solid.ejercicio6.interfaces.IIdentificable;
import java.util.Optional;

// Rol: Solo permite buscar
public interface IBuscador {
    Optional<IIdentificable> buscarPorId(String id);
}