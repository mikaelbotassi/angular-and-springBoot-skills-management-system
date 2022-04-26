package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "A IDENTIFICACAO DA TURMA NAO PODE SER NULL")
    private Integer id;

    @Column(name = "nome")
    @NotNull(message = "O NOME DA TURMA NAO PODE SER NULL")
    private String nome;

    @Column(name = "descricao")
    @NotNull(message = "A DESCRICAO DA TURMA NAO PODE SER NULL")
    private String descricao;

    @Column(name = "inicio")
    private LocalDate inicio;

    @Column(name = "termino")
    private LocalDate termino;

    @ManyToOne
    @JoinColumn(name = "id_status")
    @NotNull(message = "O STATUS DA TURMA NAO PODE SER NULL")
    private Status status;

    @Column(name = "ativo")
    private Boolean ativo;
}
