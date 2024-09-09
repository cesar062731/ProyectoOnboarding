package com.sayen.onboarding.ms_clientes.exceptions;

public class ClienteAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClienteAlreadyExistsException(String message) {
        super(message);
    }
}