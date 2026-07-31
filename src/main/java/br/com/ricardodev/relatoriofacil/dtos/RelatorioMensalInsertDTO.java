package br.com.ricardodev.relatoriofacil.dtos;

import java.math.BigDecimal;

public record RelatorioMensalInsertDTO(Integer mes,
                                       Integer ano,
                                       BigDecimal totalMonitoramento,
                                       BigDecimal totalEscoltaSaida,
                                       BigDecimal totalEscoltaEntrada,
                                       Long prestadoraId,
                                       Long clienteId,
                                       Long usuarioId
) {
}
