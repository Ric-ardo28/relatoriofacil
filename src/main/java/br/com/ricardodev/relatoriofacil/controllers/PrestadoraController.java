package br.com.ricardodev.relatoriofacil.controllers;

import br.com.ricardodev.relatoriofacil.dtos.PrestadoraDTO;
import br.com.ricardodev.relatoriofacil.services.PrestadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/prestadoras")
public class PrestadoraController {

    private final PrestadoraService prestadoraService;

    @GetMapping
    public ResponseEntity<Page<PrestadoraDTO>> findAll(Pageable pageable){
        Page<PrestadoraDTO> prestadoraDTO = prestadoraService.findAll(pageable);
        return ResponseEntity.ok(prestadoraDTO);
    }


}
