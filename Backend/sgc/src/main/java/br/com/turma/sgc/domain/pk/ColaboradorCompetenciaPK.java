package br.com.turma.sgc.domain.pk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "colaborador_competencia")
@Getter
@Setter
@Embeddable
public class ColaboradorCompetenciaPK implements Serializable{

    @Column(name = "id_colaborador")
    private int idColaborador;

    @Column(name = "id_competencia")
    private int idCompetencia;

    public ColaboradorCompetenciaPK() {
    }

    public ColaboradorCompetenciaPK(int idColaborador, int idCompetencia) {
        this.idColaborador = idColaborador;
        this.idCompetencia = idCompetencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColaboradorCompetenciaPK that = (ColaboradorCompetenciaPK) o;
        return idColaborador == that.idColaborador && idCompetencia == that.idCompetencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idColaborador, idCompetencia);
    }
}
