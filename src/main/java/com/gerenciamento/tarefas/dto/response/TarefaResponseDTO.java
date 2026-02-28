package com.gerenciamento.tarefas.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.gerenciamento.tarefas.model.enums.Prioridade;
import com.gerenciamento.tarefas.model.enums.Status;

public record TarefaResponseDTO(

                Long id,
                String title,
                String description,
                Prioridade prioridade,
                Status status,
                LocalDate dataVencimento,
                Long usuarioId,
                String usuarioNome,
                LocalDateTime criadoEm,
                LocalDateTime atualizadoEm

) {
}
