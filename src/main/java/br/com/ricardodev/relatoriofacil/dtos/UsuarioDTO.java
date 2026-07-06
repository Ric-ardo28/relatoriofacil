package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.Usuario;
import br.com.ricardodev.relatoriofacil.enums.PerfilUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "Perfil do usuário é obrigatório")
    private PerfilUsuario perfilUsuario;

    @NotNull(message = "Ativo é obrigatório")
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
