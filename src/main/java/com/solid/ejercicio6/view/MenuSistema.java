package com.solid.ejercicio6.view;

import com.solid.ejercicio6.interfaces.IIdentificable;
import com.solid.ejercicio6.model.Bicicleta;
import com.solid.ejercicio6.model.Coche;
import com.solid.ejercicio6.model.Motocicleta;
import com.solid.ejercicio6.repository.interfaces.ILectorInventario;
import com.solid.ejercicio6.service.GestorEgreso;
import com.solid.ejercicio6.service.GestorIngreso;

import javax.swing.JOptionPane;
import java.util.List;

public class MenuSistema {

    private final GestorIngreso gestorIngreso;
    private final GestorEgreso gestorEgreso;
    private final ILectorInventario lector;

    // Inyección de dependencias: El menú necesita los servicios para funcionar
    public MenuSistema(GestorIngreso gestorIngreso, GestorEgreso gestorEgreso, ILectorInventario lector) {
        this.gestorIngreso = gestorIngreso;
        this.gestorEgreso = gestorEgreso;
        this.lector = lector;
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            String opcion = solicitarOpcion();
            if (opcion == null) return; // Usuario canceló o cerró ventana

            switch (opcion) {
                case "1" -> opcionIngresar();
                case "2" -> opcionRetirar();
                case "3" -> opcionListar();
                case "4" -> continuar = false;
                default -> mostrarMensaje("Opción no válida");
            }
        }
    }

    private String solicitarOpcion() {
        return JOptionPane.showInputDialog(null, """
                === SISTEMA DE CONTROL DE VEHÍCULOS ===
                1. Ingresar Vehículo
                2. Retirar Vehículo
                3. Ver Inventario
                4. Salir
                
                Seleccione una opción:
                """);
    }

    private void opcionIngresar() {
        // Selector de tipo de vehículo
        String[] tipos = {"Coche", "Moto", "Bicicleta"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de vehículo",
                "Ingreso",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, tipos, tipos[0]);

        if (seleccion < 0) return; // Cancelado

        String placa = JOptionPane.showInputDialog("Ingrese Placa o Serial:");
        if (placa == null || placa.trim().isEmpty()) return;

        // Factory simple (Patrón Factory Method implícito)
        IIdentificable vehiculo = switch (seleccion) {
            case 0 -> new Coche(placa); // Coche
            case 1 -> new Motocicleta(placa); // Moto
            case 2 -> new Bicicleta(placa); // Bici
            default -> null;
        };

        if (vehiculo != null) {
            gestorIngreso.procesarIngreso(vehiculo);
            mostrarMensaje("Vehículo ingresado exitosamente: " + placa);
        }
    }

    private void opcionRetirar() {
        String placa = JOptionPane.showInputDialog("Ingrese Placa/Serial a retirar:");
        if (placa != null && !placa.isEmpty()) {
            // Nota: Aquí el servicio es void, pero podríamos mejorarlo para que retorne boolean
            // Para mantenerlo simple, asumimos que el log lo maneja, pero avisamos al usuario.
            gestorEgreso.procesarSalida(placa);
            mostrarMensaje("Proceso de salida ejecutado para: " + placa);
        }
    }

    private void opcionListar() {
        List<IIdentificable> lista = lector.obtenerTodos();

        if (lista.isEmpty()) {
            mostrarMensaje("El estacionamiento está vacío.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== VEHÍCULOS EN PARKING ===\n");
        for (IIdentificable v : lista) {
            sb.append("- ").append(v.getPlacaOIdentificador()).append("\n");
        }
        mostrarMensaje(sb.toString());
    }

    private void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}