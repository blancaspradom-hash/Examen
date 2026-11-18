package com.sixflags.parkmanager.service;

import org.springframework.stereotype.Service;

import com.sixflags.parkmanager.dto.DTOCompraResponse;
import com.sixflags.parkmanager.exception.BusinessException;
import com.sixflags.parkmanager.model.Boleto;

@Service
public class CompraService {
    private final BoletoService boletoService;
    private double ingresosAcumulados = 0.0;

    public CompraService(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    public synchronized DTOCompraResponse registrarCompra(String tipo, int cantidad) {
        if (cantidad < 1 || cantidad > 10) {
            throw new BusinessException("CANTIDAD_INVALIDA", "La cantidad de boletos debe estar entre 1 y 10");
        }

        Boleto boleto = boletoService.obtenerBoleto(tipo);

        double precioBase = boleto.getPrecioBase();
        double descuentoAplicado = boleto.getDescuentoPorcentaje();
        double precioUnitarioFinal = boleto.calcularPrecioUnitarioFinal();
        double totalCompra = precioUnitarioFinal * cantidad;

        ingresosAcumulados += totalCompra;

        return new DTOCompraResponse(
            boleto.getTipo(),
            cantidad,
            precioBase,
            descuentoAplicado,
            precioUnitarioFinal,
            totalCompra,
            ingresosAcumulados
        );
    }
}
