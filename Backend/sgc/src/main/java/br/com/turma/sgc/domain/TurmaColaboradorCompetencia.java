package br.com.turma.sgc.domain;

import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "turma_colaborador_competencia")
@NoArgsConstructor
@AllArgsConstructor
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


}
