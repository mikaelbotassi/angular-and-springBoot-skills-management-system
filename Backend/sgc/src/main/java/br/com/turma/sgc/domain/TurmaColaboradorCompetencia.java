package br.com.turma.sgc.domain;

import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import br.com.turma.sgc.enums.NivelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "turma_colaborador_competencia")
public class TurmaColaboradorCompetencia implements Serializable {

    @EmbeddedId
    private TurmaColaboradorCompetenciaPK id;

    @ManyToOne
    @MapsId("idTurmaFormacao")
    @JoinColumn(name = "id_turma_formacao")
    private TurmaFormacao turma;

    @ManyToOne
    @MapsId("idColaborador")
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @MapsId("idCompetencia")
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

    @Enumerated(EnumType.ORDINAL)
    private NivelEnum nivel;

    public TurmaColaboradorCompetencia(){}

    public TurmaColaboradorCompetencia(TurmaColaboradorCompetenciaPK id, TurmaFormacao turma, Colaborador colaborador, Competencia competencia, NivelEnum nivel) {
        this.id = id;
        this.turma = turma;
        this.colaborador = colaborador;
        this.competencia = competencia;
        this.nivel = nivel;
    }
}
