package com.sixflags.parkmanager.model;

public abstract class Boleto {
    protected double descuentoPorcentaje = 0.0;

    public abstract double getPrecioBase();
    public abstract String getTipo();

    public void setDescuentoPorcentaje(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new com.sixflags.parkmanager.exception.BusinessException(
                "DESCUENTO_INVALIDO", "El porcentaje debe estar entre 0 y 100"
            );
        }
        this.descuentoPorcentaje = porcentaje;
    }

    public void removerDescuento() {
        this.descuentoPorcentaje = 0.0; // Operación idempotente
    }

    public double getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public double calcularPrecioUnitarioFinal() {
        return getPrecioBase() * (1 - (descuentoPorcentaje / 100.0));
    }
}
