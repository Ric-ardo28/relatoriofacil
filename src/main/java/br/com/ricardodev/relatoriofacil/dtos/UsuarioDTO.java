package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.Usuario;
import br.com.ricardodev.relatoriofacil.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private PerfilUsuario perfilUsuario;
    private Boolean ativo;
    private LocalDateTime criadoEm;

    public UsuarioDTO(Usuario entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        perfilUsuario = entity.getPerfilUsuario();
        ativo = entity.getAtivo();
        criadoEm = entity.getCriadoEm();
    }
}
