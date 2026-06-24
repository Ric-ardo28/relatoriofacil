package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.Prestadora;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PrestadoraDTO {

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscricaoEstadual;
    private String endereco;
    private String telefone;
    private String email;
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
