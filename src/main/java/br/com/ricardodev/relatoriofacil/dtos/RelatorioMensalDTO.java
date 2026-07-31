package br.com.ricardodev.relatoriofacil.dtos;

import br.com.ricardodev.relatoriofacil.entities.RelatorioMensal;
import br.com.ricardodev.relatoriofacil.enums.StatusRelatorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RelatorioMensalDTO(Long id,
                                 Integer mes,
                                 Integer ano,
                                 StatusRelatorio statusRelatorio,
                                 BigDecimal totalMonitoramento,
                                 BigDecimal totalEscoltaSaida,
                                 BigDecimal totalEscoltaEntrada,
                                 BigDecimal valorTotal,
                                 LocalDateTime criadoEm,
                                 LocalDateTime atualizadoEm,

                                 Long prestadoraId,
                                 String prestadoraNome,

                                 Long clienteId,
                                 String clienteNome,

                                 Long usuarioId,
                                 String usuarioNome
) {
    public RelatorioMensalDTO(RelatorioMensal entity) {
        this(entity.getId(),
                entity.getMes(),
                entity.getAno(),
                entity.getStatusRelatorio(),
                entity.getTotalMonitoramento(),
                entity.getTotalEscoltaSaida(),
                entity.getTotalEscoltaEntrada(),
                entity.getValorTotal(),
                entity.getCriadoEm(),
                entity.getAtualizadoEm(),

                entity.getPrestadora().getId(),
                entity.getPrestadora().getNomeFantasia(),

                entity.getCliente().getId(),
                entity.getCliente().getNome(),

                entity.getUsuario().getId(),
                entity.getUsuario().getNome()
        );

    }
}
