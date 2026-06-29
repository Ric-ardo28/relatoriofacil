package br.com.ricardodev.relatoriofacil.controllers;

import br.com.ricardodev.relatoriofacil.dtos.PrestadoraDTO;
import br.com.ricardodev.relatoriofacil.services.PrestadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/prestadoras")
public class PrestadoraController {

    private final PrestadoraService prestadoraService;

    @GetMapping
    public ResponseEntity<Page<PrestadoraDTO>> findAll(Pageable pageable) {
        Page<PrestadoraDTO> prestadoraDTO = prestadoraService.findAll(pageable);
        return ResponseEntity.ok(prestadoraDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PrestadoraDTO> findById(@PathVariable Long id) {
        PrestadoraDTO dto = prestadoraService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PrestadoraDTO> insert(@RequestBody PrestadoraDTO prestadoraDTO) {
        prestadoraDTO = prestadoraService.insert(prestadoraDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prestadoraDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(prestadoraDTO);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PrestadoraDTO> update(@PathVariable Long id, @RequestBody PrestadoraDTO prestadoraDTO) {
        prestadoraDTO = prestadoraService.update(id, prestadoraDTO);
        return ResponseEntity.ok(prestadoraDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        prestadoraService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
