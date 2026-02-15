package com.gerenciamento.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.tarefas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
