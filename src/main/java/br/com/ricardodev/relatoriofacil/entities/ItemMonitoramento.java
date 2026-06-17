package br.com.ricardodev.relatoriofacil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_item_monitoramento")
public class ItemMonitoramento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalDias;
    private Integer horas;
    private BigDecimal valorHora;
    private String agente;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "relatorio_mensal_id")
    private RelatorioMensal relatorioMensal;
}
