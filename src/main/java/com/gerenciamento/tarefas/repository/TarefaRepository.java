package com.gerenciamento.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.tarefas.model.Tarefa;
import com.gerenciamento.tarefas.model.enums.Prioridade;
import com.gerenciamento.tarefas.model.enums.Status;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByAtribuidoId(Long usuarioId);

    List<Tarefa> findByAtribuidoIdAndStatus(Long usuarioId, Status status);

    List<Tarefa> findByAtribuidoIdAndPrioridade(Long usuarioId, Prioridade prioridade);

    List<Tarefa> findByAtribuidoIdAndTitleContaining(Long usuarioId, String title);
}
