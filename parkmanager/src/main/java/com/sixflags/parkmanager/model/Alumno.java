package com.sixflags.parkmanager.model;

public class Alumno extends Boleto {
    @Override
    public double getPrecioBase() { return 650.00; }
    @Override
    public String getTipo() { return "ALUMNO"; }
}
