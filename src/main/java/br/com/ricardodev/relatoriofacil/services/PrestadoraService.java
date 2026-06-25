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


}
