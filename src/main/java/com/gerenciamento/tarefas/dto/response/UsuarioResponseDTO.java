package com.gerenciamento.tarefas.dto.response;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(

                Long id,
                String name,
                String email,
                Boolean active,
                LocalDateTime criadoEm

) {
}
