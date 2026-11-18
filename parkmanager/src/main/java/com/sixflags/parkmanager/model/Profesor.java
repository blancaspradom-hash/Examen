package com.sixflags.parkmanager.model;

public class Profesor extends Boleto {
    @Override
    public double getPrecioBase() { return 700.00; }
    @Override
    public String getTipo() { return "PROFESOR"; }
}
