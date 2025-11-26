package com.solid.ejercicio6.repository.interfaces;

import com.solid.ejercicio6.interfaces.IIdentificable;

// Rol: Solo permite guardar
public interface IGuardador {
    void guardar(IIdentificable vehiculo);
}