package com.sayen.onboarding.ms_clientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayen.onboarding.ms_clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	 Optional<Cliente> findByNombreUsuario(String nombreUsuario);

}
