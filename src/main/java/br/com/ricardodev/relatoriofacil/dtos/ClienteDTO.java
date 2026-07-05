package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@JsonPropertyOrder({"id", "nome", "cnpj", "telefone", "email", "ativo"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    @CNPJ
    private String cnpj;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 8, message = "Telefone com no mínimo 8 números")
    private String telefone;

    @Email
    @NotBlank(message = "Campo obrigatório")
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
