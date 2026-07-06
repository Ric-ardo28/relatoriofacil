package br.com.ricardodev.relatoriofacil.services;

import br.com.ricardodev.relatoriofacil.dtos.ClienteDTO;
import br.com.ricardodev.relatoriofacil.entities.Cliente;
import br.com.ricardodev.relatoriofacil.repositories.ClienteRepository;
import br.com.ricardodev.relatoriofacil.services.exceptions.DatabaseException;
import br.com.ricardodev.relatoriofacil.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable) {
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        return clientes.map(ClienteDTO::new);
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClienteDTO(cliente);
    }

    @Transactional
    public ClienteDTO insert(ClienteDTO clienteDTO) {
        Cliente entity = new Cliente();
        copiarDadosDTO(clienteDTO, entity);
        entity = clienteRepository.save(entity);

        return new ClienteDTO(entity);
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        Cliente entity = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        copiarDadosDTO(clienteDTO, entity);
        entity = clienteRepository.save(entity);

        return new ClienteDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");

        }
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copiarDadosDTO(ClienteDTO clienteDTO, Cliente entity) {
        entity.setNome(clienteDTO.getNome());
        entity.setCnpj(clienteDTO.getCnpj());
        entity.setTelefone(clienteDTO.getTelefone());
        entity.setEmail(clienteDTO.getEmail());
        entity.setAtivo(clienteDTO.getAtivo());
    }


}
