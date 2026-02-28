package com.gerenciamento.tarefas.mapper;

import com.gerenciamento.tarefas.dto.request.TarefaRequestDTO;
import com.gerenciamento.tarefas.dto.response.TarefaResponseDTO;
import com.gerenciamento.tarefas.model.Tarefa;
import com.gerenciamento.tarefas.model.Usuario;

public class TarefaMapper {

    private TarefaMapper() {
    }

    public static Tarefa toEntity(TarefaRequestDTO dto, Usuario usuario) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitle(dto.title());
        tarefa.setDescription(dto.description());
        tarefa.setPrioridade(dto.prioridade());
        tarefa.setStatus(dto.status());
        tarefa.setDataVencimento(dto.dataVencimento());
        tarefa.setAtribuido(usuario);
        return tarefa;
    }

    public static void updateEntity(Tarefa tarefa, TarefaRequestDTO dto, Usuario usuario) {
        tarefa.setTitle(dto.title());
        tarefa.setDescription(dto.description());
        tarefa.setPrioridade(dto.prioridade());
        tarefa.setStatus(dto.status());
        tarefa.setDataVencimento(dto.dataVencimento());
        tarefa.setAtribuido(usuario);
    }

    public static TarefaResponseDTO toResponseDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitle(),
                tarefa.getDescription(),
                tarefa.getPrioridade(),
                tarefa.getStatus(),
                tarefa.getDataVencimento(),
                tarefa.getAtribuido() != null ? tarefa.getAtribuido().getId() : null,
                tarefa.getAtribuido() != null ? tarefa.getAtribuido().getName() : null,
                tarefa.getCriadoEm(),
                tarefa.getAtualizadoEm());
    }
}
