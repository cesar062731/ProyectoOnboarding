package com.sayen.onboarding.ms_clientes.service;

import com.sayen.onboarding.ms_clientes.model.Cliente;
import com.sayen.onboarding.ms_clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger logger = Logger.getLogger(ClienteServiceImpl.class.getName());

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        logger.info("Registrando cliente: " + cliente.getNombreUsuario());
        
        // Verificar si el nombre de usuario ya existe
        Optional<Cliente> clienteExistente = clienteRepository.findByNombreUsuario(cliente.getNombreUsuario());
        if (clienteExistente.isPresent()) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        // Codificar la contraseña
        cliente.setContrasena(passwordEncoder.encode(cliente.getContrasena()));
        
        // Guardar el cliente
        Cliente clienteGuardado = clienteRepository.save(cliente);
        logger.info("Cliente registrado exitosamente: " + clienteGuardado.getNombreUsuario());
        
        return clienteGuardado;
    }
}