package com.gerenciamento.tarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciamento.tarefas.dto.request.TarefaRequestDTO;
import com.gerenciamento.tarefas.dto.response.TarefaResponseDTO;
import com.gerenciamento.tarefas.mapper.TarefaMapper;
import com.gerenciamento.tarefas.model.Tarefa;
import com.gerenciamento.tarefas.model.Usuario;
import com.gerenciamento.tarefas.repository.TarefaRepository;
import com.gerenciamento.tarefas.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaResponseDTO criar(TarefaRequestDTO dto) {
        Usuario usuario = null;
        if (dto.usuarioId() != null) {
            usuario = usuarioRepository.findById(dto.usuarioId())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Usuário não encontrado com id: " + dto.usuarioId()));
        }
        Tarefa tarefa = TarefaMapper.toEntity(dto, usuario);
        tarefa = tarefaRepository.save(tarefa);
        return TarefaMapper.toResponseDTO(tarefa);
    }

    public List<TarefaResponseDTO> listarTodas() {
        return tarefaRepository.findAll()
                .stream()
                .map(TarefaMapper::toResponseDTO)
                .toList();
    }

    public TarefaResponseDTO buscarPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));
        return TarefaMapper.toResponseDTO(tarefa);
    }

    public TarefaResponseDTO atualizar(Long id, TarefaRequestDTO dto) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));

        Usuario usuario = null;
        if (dto.usuarioId() != null) {
            usuario = usuarioRepository.findById(dto.usuarioId())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Usuário não encontrado com id: " + dto.usuarioId()));
        }

        TarefaMapper.updateEntity(tarefa, dto, usuario);
        tarefa = tarefaRepository.save(tarefa);
        return TarefaMapper.toResponseDTO(tarefa);
    }

    public void deletar(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada com id: " + id);
        }
        tarefaRepository.deleteById(id);
    }

    public List<TarefaResponseDTO> listarPorUsuario(Long usuarioId) {
        return tarefaRepository.findByAtribuidoId(usuarioId)
                .stream()
                .map(TarefaMapper::toResponseDTO)
                .toList();
    }
}
