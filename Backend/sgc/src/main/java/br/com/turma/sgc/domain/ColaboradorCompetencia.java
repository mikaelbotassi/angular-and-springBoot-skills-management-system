package br.com.turma.sgc.domain;

import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "turma_colaborador_competencia")
public class ColaboradorCompetencia implements Serializable {

    @EmbeddedId
    private ColaboradorCompetenciaPK id;


    @ManyToOne
    @MapsId("idColaborador")
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @MapsId("idCompetencia")
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

    public ColaboradorCompetencia(){}

    public ColaboradorCompetencia(ColaboradorCompetenciaPK id,  Colaborador colaborador, Competencia competencia) {
        this.id = id;
        this.colaborador = colaborador;
        this.competencia = competencia;
    }
}
