package com.sixflags.parkmanager.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sixflags.parkmanager.exception.BusinessException;
import com.sixflags.parkmanager.model.Alumno;
import com.sixflags.parkmanager.model.Boleto;
import com.sixflags.parkmanager.model.General;
import com.sixflags.parkmanager.model.PaseAnual;
import com.sixflags.parkmanager.model.Profesor;

@Service
public class BoletoService {
    private final Map<String, Boleto> boletos = new HashMap<>();

    public BoletoService() {
        boletos.put("GENERAL", new General());
        boletos.put("PASE_ANUAL", new PaseAnual());
        boletos.put("ALUMNO", new Alumno());
        boletos.put("PROFESOR", new Profesor());
    }

    public Boleto obtenerBoleto(String tipo) {
        if (tipo == null || !boletos.containsKey(tipo.toUpperCase())) {
            throw new BusinessException("TIPO_BOLETO_INVALIDO", "El tipo de boleto no existe o es inválido");
        }
        return boletos.get(tipo.toUpperCase());
    }
}
