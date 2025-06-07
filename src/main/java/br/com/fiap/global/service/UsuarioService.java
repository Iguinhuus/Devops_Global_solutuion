package br.com.fiap.global.service;

import br.com.fiap.global.model.DTO.UsuarioDTO;
import br.com.fiap.global.model.Usuario;
import br.com.fiap.global.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }

    private Usuario toEntity(UsuarioDTO dto) {
        return new Usuario(dto.getId(), dto.getNome(), dto.getEmail(), dto.getTelefone());
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getId() != null && usuarioDTO.getId().isBlank()) {
            usuarioDTO.setId(null);
        }
        Usuario usuario = toEntity(usuarioDTO);
        Usuario salvo = usuarioRepository.save(usuario);
        return toDTO(salvo);
    }

    public Optional<UsuarioDTO> buscarPorId(String id) {
        return usuarioRepository.findById(id).map(this::toDTO);
    }

    public void excluir(String id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado para exclusão");
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getId() == null || !usuarioRepository.existsById(usuarioDTO.getId())) {
            throw new IllegalArgumentException("Usuário não encontrado para atualização");
        }
        Usuario usuario = toEntity(usuarioDTO);
        return toDTO(usuarioRepository.save(usuario));
    }
}