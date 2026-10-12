package br.com.ricardodev.relatoriofacil.services;

import br.com.ricardodev.relatoriofacil.dtos.RelatorioMensalDTO;
import br.com.ricardodev.relatoriofacil.dtos.RelatorioMensalInsertDTO;
import br.com.ricardodev.relatoriofacil.entities.Cliente;
import br.com.ricardodev.relatoriofacil.entities.Prestadora;
import br.com.ricardodev.relatoriofacil.entities.RelatorioMensal;
import br.com.ricardodev.relatoriofacil.entities.Usuario;
import br.com.ricardodev.relatoriofacil.enums.StatusRelatorio;
import br.com.ricardodev.relatoriofacil.repositories.ClienteRepository;
import br.com.ricardodev.relatoriofacil.repositories.PrestadoraRepository;
import br.com.ricardodev.relatoriofacil.repositories.RelatorioMensalRepository;
import br.com.ricardodev.relatoriofacil.repositories.UsuarioRepository;
import br.com.ricardodev.relatoriofacil.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RelatorioMensalService {

    private final RelatorioMensalRepository relatorioMensalRepository;
    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final PrestadoraRepository prestadoraRepository;

    @Transactional(readOnly = true)
    public RelatorioMensalDTO findById(Long id) {
        RelatorioMensal relatorioMensal = relatorioMensalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new RelatorioMensalDTO(relatorioMensal);
    }


    @Transactional(readOnly = true)
    public Page<RelatorioMensalDTO> findAll(Pageable pageable) {
        Page<RelatorioMensal> relatorioMensals = relatorioMensalRepository.findAll(pageable);
        return relatorioMensals.map(RelatorioMensalDTO::new);
    }


    @Transactional
    public RelatorioMensalDTO insert(RelatorioMensalInsertDTO dto) {
        RelatorioMensal entity = new RelatorioMensal();

        Prestadora prestadora = prestadoraRepository.getReferenceById(dto.prestadoraId());
        Cliente cliente = clienteRepository.getReferenceById(dto.clienteId());
        Usuario usuario = usuarioRepository.getReferenceById(dto.usuarioId());

        entity.setPrestadora(prestadora);
        entity.setCliente(cliente);
        entity.setUsuario(usuario);

        copiarDadosDTO(dto, entity);

        entity.setValorTotal(calcularValorTotal(dto));
        entity.setStatusRelatorio(StatusRelatorio.RASCUNHO);
        entity.setCriadoEm(LocalDateTime.now());

        entity = relatorioMensalRepository.save(entity);

        return new RelatorioMensalDTO(entity);


    }

    private void copiarDadosDTO(RelatorioMensalInsertDTO dto, RelatorioMensal entity) {
        entity.setMes(dto.mes());
        entity.setAno(dto.ano());
        entity.setTotalMonitoramento(dto.totalMonitoramento());
        entity.setTotalEscoltaSaida(dto.totalEscoltaSaida());
        entity.setTotalEscoltaEntrada(dto.totalEscoltaEntrada());
    }

    private BigDecimal calcularValorTotal(RelatorioMensalInsertDTO dto) {
        return dto.totalMonitoramento()
                .add(dto.totalEscoltaSaida())
                .add(dto.totalEscoltaEntrada());
    }

}
