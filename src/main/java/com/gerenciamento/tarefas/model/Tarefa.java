package com.gerenciamento.tarefas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.gerenciamento.tarefas.model.enums.Priority;
import com.gerenciamento.tarefas.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "tb_tarefas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
    
    private Priority priority;

    private Status status;
    
    private LocalDate dueDate;
    
    @ManyToOne
    private Projeto projeto;
    
    @ManyToOne
    private Usuario atribuido;

    private Integer horasEstimadas;

    private Integer horasRealizadas;

    
    @OneToMany
    private List<Comentario> comentarios;

    @OneToMany
    private List<Anexo> anexos;


    @Column(name = "criado_em")
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
    
    
}