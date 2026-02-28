package com.gerenciamento.tarefas.dto.request;

import java.time.LocalDate;

import com.gerenciamento.tarefas.model.enums.Prioridade;
import com.gerenciamento.tarefas.model.enums.Status;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequestDTO(

                @NotBlank(message = "O título é obrigatório") String title,

                String description,

                Prioridade prioridade,

                Status status,

                LocalDate dataVencimento,

                Long usuarioId

) {
}
