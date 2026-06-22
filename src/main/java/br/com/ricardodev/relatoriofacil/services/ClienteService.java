package br.com.ricardodev.relatoriofacil.services;

import br.com.ricardodev.relatoriofacil.dtos.ClienteDTO;
import br.com.ricardodev.relatoriofacil.entities.Cliente;
import br.com.ricardodev.relatoriofacil.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable){
        Page<Cliente> cliente = clienteRepository.findAll(pageable);
        return cliente.map(ClienteDTO::new);
    }

}
