package br.com.turma.sgc.domain;

import br.com.turma.sgc.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "TURMA_FORMACAO")
public class TurmaFormacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TURMA_FORMACAO")
    @SequenceGenerator(name = "SQ_TURMA_FORMACAO", sequenceName = "sq_turma_formacao", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "inicio")
    private LocalDate inicio;

    @Column(name = "termino")
    private LocalDate termino;

    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;
}
