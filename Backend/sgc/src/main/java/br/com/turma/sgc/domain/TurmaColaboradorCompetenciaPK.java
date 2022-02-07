package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "turma_colaborador_competencia")
@Embeddable
@Getter
@Setter
public class TurmaColaboradorCompetenciaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_turma_formacao", nullable=false, referencedColumnName = "id")
    private TurmaFormacao tumaFormacao;

    @ManyToOne
    @JoinColumn(name="id_colaborador", nullable=false, referencedColumnName = "id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name="id_competencia", nullable=false, referencedColumnName = "id")
    private Competencia competencia;

}
