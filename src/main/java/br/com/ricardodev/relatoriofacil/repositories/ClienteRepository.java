package br.com.ricardodev.relatoriofacil.repositories;

import br.com.ricardodev.relatoriofacil.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
