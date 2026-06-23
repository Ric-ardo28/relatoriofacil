package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({"id", "nome", "cnpj", "telefone", "email", "ativo"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private Boolean ativo;

    public ClienteDTO(Cliente entity) {
        id = entity.getId();
        nome = entity.getNome();
        cnpj = entity.getCnpj();
        telefone = entity.getTelefone();
        email = entity.getEmail();
        ativo = entity.getAtivo();
    }
}
