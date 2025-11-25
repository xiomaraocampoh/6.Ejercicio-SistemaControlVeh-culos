package com.solid.ejercicio6;

// Solo implementa IVehiculo. No la forzamos a tener motor.
class Bicicleta implements IVehiculo {
    private String idSerial;

    public Bicicleta(String idSerial) {
        this.idSerial = idSerial;
    }

    // Al no implementar IMotorizable, no necesitamos dejar métodos vacíos ni lanzar errores.

    @Override
    public void conducir() {
        System.out.println("Bici " + idSerial + ": Pedaleando con energía.");
    }

    @Override
    public String getPlacaOIdentificador() {
        return "BICI-" + idSerial;
    }
}