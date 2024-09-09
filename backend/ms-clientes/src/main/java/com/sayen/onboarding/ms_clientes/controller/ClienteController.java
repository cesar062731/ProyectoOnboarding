package com.sayen.onboarding.ms_clientes.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayen.onboarding.ms_clientes.model.Cliente;
import com.sayen.onboarding.ms_clientes.service.ClienteService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde este origen
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private static final Logger logger = Logger.getLogger(ClienteController.class.getName());

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/registrar")
    public Cliente registrarCliente(@Valid @RequestBody Cliente cliente) {
        logger.info("Solicitud recibida para registrar cliente: " + cliente.getNombreUsuario());
        return clienteService.registrarCliente(cliente);
    }
}