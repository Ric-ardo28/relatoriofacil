package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInsertDTO {

    private String nome;
    private String email;
    private String senha;
    private PerfilUsuario perfilUsuario;
    private Boolean ativo;
}