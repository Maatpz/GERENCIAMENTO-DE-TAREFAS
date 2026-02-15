package com.gerenciamento.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.tarefas.model.Tarefa;
import com.gerenciamento.tarefas.model.enums.Prioridade;
import com.gerenciamento.tarefas.model.enums.Status;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
    List<Tarefa> findByUsuarioId(Long usuarioId);
    
    List<Tarefa> findByUsuarioIdAndStatus(Long usuarioId, Status status);
    
    List<Tarefa> findByUsuarioIdAndPrioridade(Long usuarioId, Prioridade prioridade);
    
    List<Tarefa> findByUsuarioIdAndTituloContaining(Long usuarioId, String titulo);
}
