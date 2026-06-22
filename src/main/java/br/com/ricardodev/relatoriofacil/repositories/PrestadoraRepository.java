package br.com.ricardodev.relatoriofacil.repositories;

import br.com.ricardodev.relatoriofacil.entities.Prestadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadoraRepository extends JpaRepository<Prestadora, Long> {
}
