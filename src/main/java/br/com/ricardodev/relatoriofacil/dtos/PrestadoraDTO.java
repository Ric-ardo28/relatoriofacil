package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.Prestadora;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PrestadoraDTO {

    private Long id;
    @NotBlank(message = "Razão social é obrigatória")
    private String razaoSocial;

    @NotBlank(message = "Nome fantasia é obrigatório")
    private String nomeFantasia;

    @NotBlank(message = "CNPJ é obrigatório")
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    private String inscricaoEstadual;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\d{8,14}", message = "Telefone deve conter entre 8 e 14 números")
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "Ativo é obrigatório")
    private Boolean ativo;

    public PrestadoraDTO(Prestadora entity) {
        id = entity.getId();
        razaoSocial = entity.getRazaoSocial();
        nomeFantasia = entity.getNomeFantasia();
        cnpj = entity.getCnpj();
        inscricaoEstadual = entity.getInscricaoEstadual();
        endereco = entity.getEndereco();
        telefone = entity.getTelefone();
        email = entity.getEmail();
        ativo = entity.getAtivo();
    }
}
