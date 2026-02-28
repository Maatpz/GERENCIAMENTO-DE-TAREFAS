package com.gerenciamento.tarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciamento.tarefas.dto.request.UsuarioRequestDTO;
import com.gerenciamento.tarefas.dto.response.UsuarioResponseDTO;
import com.gerenciamento.tarefas.mapper.UsuarioMapper;
import com.gerenciamento.tarefas.model.Usuario;
import com.gerenciamento.tarefas.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));
        return UsuarioMapper.toResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));

        UsuarioMapper.updateEntity(usuario, dto);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDTO(usuario);
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
