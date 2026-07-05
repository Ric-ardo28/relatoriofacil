package br.com.ricardodev.relatoriofacil.services;

import br.com.ricardodev.relatoriofacil.dtos.UsuarioDTO;
import br.com.ricardodev.relatoriofacil.dtos.UsuarioInsertDTO;
import br.com.ricardodev.relatoriofacil.entities.Usuario;
import br.com.ricardodev.relatoriofacil.repositories.UsuarioRepository;
import br.com.ricardodev.relatoriofacil.services.exceptions.DatabaseException;
import br.com.ricardodev.relatoriofacil.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findAll(Pageable pageable) {
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return usuarios.map(UsuarioDTO::new);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public UsuarioDTO insert(UsuarioInsertDTO usuarioInsertDTO) {
        Usuario entity = new Usuario();
        copiarDadosDTO(usuarioInsertDTO, entity);
        entity.setCriadoEm(LocalDateTime.now());
        entity = usuarioRepository.save(entity);
        return new UsuarioDTO(entity);
    }

    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        Usuario entity = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        copiarDadosDTO(usuarioDTO, entity);
        entity = usuarioRepository.save(entity);
        return new UsuarioDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
       if(!usuarioRepository.existsById(id)) {
           throw new ResourceNotFoundException("Recurso não encontrado");

       }
       try {
           usuarioRepository.deleteById(id);
       }
       catch (DataIntegrityViolationException e){
           throw new DatabaseException("Falha de integridade referencial");
       }
    }

    private void copiarDadosDTO(UsuarioDTO usuarioDTO, Usuario entity) {
        entity.setNome(usuarioDTO.getNome());
        entity.setEmail(usuarioDTO.getEmail());
        entity.setPerfilUsuario(usuarioDTO.getPerfilUsuario());
        entity.setAtivo(usuarioDTO.getAtivo());
    }

    private void copiarDadosDTO(UsuarioInsertDTO usuarioInsertDTO, Usuario entity) {
        entity.setNome(usuarioInsertDTO.getNome());
        entity.setEmail(usuarioInsertDTO.getEmail());
        entity.setSenha(usuarioInsertDTO.getSenha());
        entity.setPerfilUsuario(usuarioInsertDTO.getPerfilUsuario());
        entity.setAtivo(usuarioInsertDTO.getAtivo());
    }

}
