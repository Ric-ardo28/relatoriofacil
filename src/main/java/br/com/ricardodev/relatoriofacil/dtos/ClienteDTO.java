package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
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
    @CNPJ(message = "CNPJ invalido")
    private String cnpj;

    @NotBlank(message = "Campo obrigatório")
    @Pattern(regexp = "\\d{8,14}", message = "Telefone deve conter entre 8 e 14 números")
    private String telefone;

    @Email(message = "Email invalido")
    @NotBlank(message = "Campo obrigatório")
    private String email;

    @NotNull(message = "Campo obrigatório")
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
