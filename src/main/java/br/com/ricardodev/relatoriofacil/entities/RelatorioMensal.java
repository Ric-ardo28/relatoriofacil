package br.com.ricardodev.relatoriofacil.entities;

import br.com.ricardodev.relatoriofacil.enums.StatusRelatorio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_relatorio_mensal")
public class RelatorioMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer mes;
    private Integer ano;
    @Enumerated(EnumType.STRING)
    private StatusRelatorio statusRelatorio;
    private BigDecimal totalMonitoramento;
    private BigDecimal totalEscoltaSaida;
    private BigDecimal totalEscoltaEntrada;
    private BigDecimal valorTotal;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    @ManyToOne
    @JoinColumn(name = "prestadora_id")
    private Prestadora prestadora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
