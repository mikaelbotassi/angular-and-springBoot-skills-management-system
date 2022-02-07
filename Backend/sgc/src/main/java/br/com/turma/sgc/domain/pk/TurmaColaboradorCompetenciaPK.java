package br.com.turma.sgc.domain.pk;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "turma_colaborador_competencia")
@Getter
@Setter
@Embeddable
public class TurmaColaboradorCompetenciaPK implements Serializable {

    @Column(name = "id_turma_formacao")
    private int idTurmaFormacao;

    @Column(name = "id_colaborador")
    private int idColaborador;

    @Column(name = "id_competencia")
    private int idCompetencia;

    public TurmaColaboradorCompetenciaPK() {
    }

    public TurmaColaboradorCompetenciaPK(int idTurmaFormacao, int idColaborador, int idCompetencia) {
        this.idTurmaFormacao = idTurmaFormacao;
        this.idColaborador = idColaborador;
        this.idCompetencia = idCompetencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaColaboradorCompetenciaPK that = (TurmaColaboradorCompetenciaPK) o;
        return idTurmaFormacao == that.idTurmaFormacao && idColaborador == that.idColaborador && idCompetencia == that.idCompetencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTurmaFormacao, idColaborador, idCompetencia);
    }
}
