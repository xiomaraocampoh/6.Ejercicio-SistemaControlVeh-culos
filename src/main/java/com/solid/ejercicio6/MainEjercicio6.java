package com.solid.ejercicio6;

import com.solid.ejercicio6.repository.RepositorioParking;
import com.solid.ejercicio6.service.GestorIngreso;
import com.solid.ejercicio6.service.GestorEgreso;
import com.solid.ejercicio6.view.MenuSistema;


public class MainEjercicio6 {
    public static void main(String[] args) {
        // 1. Configuración de Dependencias (Infraestructura)
        RepositorioParking repoCentral = new RepositorioParking();

        // 2. Creación de Servicios (Lógica de Negocio)
        // Nota: repoCentral actúa como IGuardador, IEliminador, IBuscador e ILector
        GestorIngreso srvIngreso = new GestorIngreso(repoCentral);
        GestorEgreso srvEgreso = new GestorEgreso(repoCentral, repoCentral);

        // 3. Creación de la Vista (UI)
        MenuSistema menu = new MenuSistema(srvIngreso, srvEgreso, repoCentral);

        // 4. Ejecución
        menu.iniciar();
    }
}