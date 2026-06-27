package br.com.ricardodev.relatoriofacil.services;

import br.com.ricardodev.relatoriofacil.dtos.PrestadoraDTO;
import br.com.ricardodev.relatoriofacil.entities.Prestadora;
import br.com.ricardodev.relatoriofacil.repositories.PrestadoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PrestadoraService {


    private final PrestadoraRepository prestadoraRepository;

    @Transactional(readOnly = true)
    public Page<PrestadoraDTO> findAll(Pageable pageable) {
        Page<Prestadora> prestadoras = prestadoraRepository.findAll(pageable);
        return prestadoras.map(PrestadoraDTO::new);
    }

    @Transactional(readOnly = true)
    public PrestadoraDTO findById(Long id) {
        Prestadora prestadora = prestadoraRepository.findById(id).get();
        return new PrestadoraDTO(prestadora);
    }

    @Transactional
    public PrestadoraDTO insert(PrestadoraDTO prestadoraDTO) {
        Prestadora entity = new Prestadora();
        copiarDadosDTO(prestadoraDTO, entity);
        entity = prestadoraRepository.save(entity);
        return new PrestadoraDTO(entity);
    }

    public PrestadoraDTO update(Long id, PrestadoraDTO prestadoraDTO) {
        Prestadora entity = prestadoraRepository.getReferenceById(id);
        copiarDadosDTO(prestadoraDTO, entity);
        entity = prestadoraRepository.save(entity);
        return new PrestadoraDTO(entity);
    }

    public void delete(Long id) {
        prestadoraRepository.deleteById(id);
    }


    private void copiarDadosDTO(PrestadoraDTO prestadoraDTO, Prestadora entity) {
        entity.setId(prestadoraDTO.getId());
        entity.setRazaoSocial(prestadoraDTO.getRazaoSocial());
        entity.setNomeFantasia(prestadoraDTO.getNomeFantasia());
        entity.setCnpj(prestadoraDTO.getCnpj());
        entity.setInscricaoEstadual(prestadoraDTO.getInscricaoEstadual());
        entity.setEndereco(prestadoraDTO.getEndereco());
        entity.setTelefone(prestadoraDTO.getTelefone());
        entity.setEmail(prestadoraDTO.getEmail());
        entity.setAtivo(prestadoraDTO.getAtivo());
    }


}
