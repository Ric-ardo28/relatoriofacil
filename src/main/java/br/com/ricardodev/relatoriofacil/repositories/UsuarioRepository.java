package br.com.ricardodev.relatoriofacil.repositories;

import br.com.ricardodev.relatoriofacil.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
