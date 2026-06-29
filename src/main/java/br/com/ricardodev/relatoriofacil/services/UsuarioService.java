package br.com.ricardodev.relatoriofacil.services;

import br.com.ricardodev.relatoriofacil.dtos.UsuarioDTO;
import br.com.ricardodev.relatoriofacil.dtos.UsuarioInsertDTO;
import br.com.ricardodev.relatoriofacil.entities.Usuario;
import br.com.ricardodev.relatoriofacil.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
        Usuario usuario = usuarioRepository.findById(id).get();
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
        Usuario entity = usuarioRepository.getReferenceById(id);
        copiarDadosDTO(usuarioDTO, entity);
        entity = usuarioRepository.save(entity);
        return new UsuarioDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
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
