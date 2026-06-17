package br.com.ricardodev.relatoriofacil.entities;

import br.com.ricardodev.relatoriofacil.enums.TipoEscolta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_escolta")
public class Escolta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoEscolta tipoEscolta;
    private LocalDate dataServico;
    private LocalTime horario;
    private BigDecimal valor;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "relatorio_mensal_id")
    private RelatorioMensal relatorioMensal;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

}
