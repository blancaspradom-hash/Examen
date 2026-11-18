package com.sixflags.parkmanager.dto;

public class DTOCompraResponse {
    private String tipo;
    private int cantidad;
    private double precioBase;
    private double descuentoAplicado;
    private double precioUnitarioFinal;
    private double total;
    private double ingresosAcumulados;

    public DTOCompraResponse(String tipo, int cantidad, double precioBase, double descuentoAplicado, 
                             double precioUnitarioFinal, double total, double ingresosAcumulados) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.descuentoAplicado = descuentoAplicado;
        this.precioUnitarioFinal = precioUnitarioFinal;
        this.total = total;
        this.ingresosAcumulados = ingresosAcumulados;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public double getDescuentoAplicado() { return descuentoAplicado; }
    public void setDescuentoAplicado(double descuentoAplicado) { this.descuentoAplicado = descuentoAplicado; }

    public double getPrecioUnitarioFinal() { return precioUnitarioFinal; }
    public void setPrecioUnitarioFinal(double precioUnitarioFinal) { this.precioUnitarioFinal = precioUnitarioFinal; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getIngresosAcumulados() { return ingresosAcumulados; }
    public void setIngresosAcumulados(double ingresosAcumulados) { this.ingresosAcumulados = ingresosAcumulados; }
}
