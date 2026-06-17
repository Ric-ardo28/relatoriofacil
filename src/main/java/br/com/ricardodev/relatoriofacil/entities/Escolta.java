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
    private TipoEscolta tipoEscolta;
    private LocalDate dataService;
    private LocalTime horario;
    private BigDecimal valor;
    private String observacao;

}
