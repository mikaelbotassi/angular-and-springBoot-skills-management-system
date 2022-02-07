package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "turma_colaborador_competencia")
@Embeddable
public class TurmaColaboradorCompetenciaPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_turma_formacao", nullable=false, referencedColumnName = "id")
    private TurmaFormacao tumaFormacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_colaborador", nullable=false, referencedColumnName = "id")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_competencia", nullable=false, referencedColumnName = "id")
    private Competencia competencia;

}
