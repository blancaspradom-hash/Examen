package com.sixflags.parkmanager.model;

public class General extends Boleto {
    @Override
    public double getPrecioBase() { return 900.00; }
    @Override
    public String getTipo() { return "GENERAL"; }
}
