package com.sixflags.parkmanager.model;

public class PaseAnual extends Boleto {
    @Override
    public double getPrecioBase() { return 2400.00; }
    @Override
    public String getTipo() { return "PASE_ANUAL"; }
}
