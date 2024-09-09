package com.sayen.onboarding.ms_login.service;

import com.sayen.onboarding.ms_login.model.Usuario;

public interface UsuarioService {
    Usuario autenticarUsuario(String nombreUsuario, String contrasena);
}