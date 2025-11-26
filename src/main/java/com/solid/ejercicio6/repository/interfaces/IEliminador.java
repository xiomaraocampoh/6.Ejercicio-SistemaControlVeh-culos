package com.solid.ejercicio6.repository.interfaces;

import com.solid.ejercicio6.interfaces.IIdentificable;

// Rol: Solo permite eliminar
public interface IEliminador {
    void eliminar(IIdentificable vehiculo);
}