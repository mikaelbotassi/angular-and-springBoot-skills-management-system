package br.com.turma.sgc.domain.pk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "turma_colaborador_competencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TurmaColaboradorCompetenciaPK implements Serializable {

    @Column(name = "id_turma_formacao")
    private Integer idTurmaFormacao;

    @Column(name = "id_colaborador")
    private Integer idColaborador;

    @Column(name = "id_competencia")
    private Integer idCompetencia;

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
