package com.gerenciamento.tarefas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.gerenciamento.tarefas.model.enums.Priority;
import com.gerenciamento.tarefas.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String title;

    private String description;
    
    @Enumerated(EnumType.STRING)
    private Priority prioridade;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario atribuido;

    @Column(name = "criado_em")
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @LastModifiedDate
    private LocalDateTime atualizadoEm;
    
}
