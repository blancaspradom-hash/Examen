package com.sixflags.parkmanager.controller;

import com.sixflags.parkmanager.dto.CompraRequest;
import com.sixflags.parkmanager.dto.DTOCompraResponse;
import com.sixflags.parkmanager.dto.DescuentoRequest;
import com.sixflags.parkmanager.model.Boleto;
import com.sixflags.parkmanager.service.BoletoService;
import com.sixflags.parkmanager.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ParkController {

    private final BoletoService boletoService;
    private final CompraService compraService;

    public ParkController(BoletoService boletoService, CompraService compraService) {
        this.boletoService = boletoService;
        this.compraService = compraService;
    }

    @PutMapping("/descuentos/{tipo}")
    public ResponseEntity<?> configurarDescuento(@PathVariable String tipo, @RequestBody DescuentoRequest request) {
        Boleto boleto = boletoService.obtenerBoleto(tipo);
        boleto.setDescuentoPorcentaje(request.getPorcentaje());

        return ResponseEntity.ok(Map.of(
            "tipo", boleto.getTipo(),
            "porcentaje", boleto.getDescuentoPorcentaje(),
            "mensaje", "Descuento configurado"
        ));
    }

    @DeleteMapping("/descuentos/{tipo}")
    public ResponseEntity<?> removerDescuento(@PathVariable String tipo) {
        Boleto boleto = boletoService.obtenerBoleto(tipo);
        boleto.removerDescuento();

        return ResponseEntity.ok(Map.of(
            "tipo", boleto.getTipo(),
            "porcentaje", 0.0,
            "mensaje", "Descuento removido"
        ));
    }

    @PostMapping("/compras")
    public ResponseEntity<DTOCompraResponse> registrarCompra(@RequestBody CompraRequest request) {
        DTOCompraResponse response = compraService.registrarCompra(request.getTipo(), request.getCantidad());
        return ResponseEntity.ok(response);
    }
}
