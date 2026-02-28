package com.gerenciamento.tarefas.mapper;

import com.gerenciamento.tarefas.dto.request.UsuarioRequestDTO;
import com.gerenciamento.tarefas.dto.response.UsuarioResponseDTO;
import com.gerenciamento.tarefas.model.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setName(dto.name());
        usuario.setEmail(dto.email());
        usuario.setPassword(dto.password());
        usuario.setActive(true);
        return usuario;
    }

    public static void updateEntity(Usuario usuario, UsuarioRequestDTO dto) {
        usuario.setName(dto.name());
        usuario.setEmail(dto.email());
        usuario.setPassword(dto.password());
    }

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getActive(),
                usuario.getCriadoEm());
    }
}
