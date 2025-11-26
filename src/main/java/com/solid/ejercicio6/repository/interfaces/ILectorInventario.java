package com.solid.ejercicio6.repository.interfaces;

import com.solid.ejercicio6.interfaces.IIdentificable;

import java.util.List;

// Rol: Solo permite ver el inventario completo
public interface ILectorInventario {
    List<IIdentificable> obtenerTodos();
}