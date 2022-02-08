package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "turma_formacao")
public class TurmaFormacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TURMA")
    @SequenceGenerator(name = "SQ_TURMA", sequenceName = "sq_turma_formacao", allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "inicio")
    private LocalDate inicio;

    @Column(name = "termino")
    private LocalDate termino;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
}
