package br.com.ricardodev.relatoriofacil.controllers;

import br.com.ricardodev.relatoriofacil.dtos.ClienteDTO;
import br.com.ricardodev.relatoriofacil.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable){
        Page<ClienteDTO> dto = clienteService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
}
