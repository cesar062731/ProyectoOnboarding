package com.sayen.onboarding.ms_login.controller;

import com.sayen.onboarding.ms_login.model.Usuario;
import com.sayen.onboarding.ms_login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class UsuarioController {

    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario autenticarUsuario(@RequestBody UsuarioLoginRequest loginRequest) {
        logger.info("Solicitud recibida para autenticar usuario: " + loginRequest.getNombreUsuario());
        return usuarioService.autenticarUsuario(loginRequest.getNombreUsuario(), loginRequest.getContrasena());
    }

    public static class UsuarioLoginRequest {
        private String nombreUsuario;
        private String contrasena;

        // Getters y setters
        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }
    }
}