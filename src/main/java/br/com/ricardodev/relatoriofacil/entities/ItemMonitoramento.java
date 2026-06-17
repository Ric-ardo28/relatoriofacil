package br.com.ricardodev.relatoriofacil.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_item_moitoramento")
public class ItemMonitoramento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalDias;
    private Integer horas;
    private BigDecimal valorHora;
    private String agente;
    private BigDecimal valorTotal;
}
