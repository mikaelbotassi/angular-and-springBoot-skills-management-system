package br.com.turma.sgc.domain.pk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ColaboradorCompetenciaPK implements Serializable{

    @Column(name = "id_colaborador")
    private Integer idColaborador;

    @Column(name = "id_competencia")
    private Integer idCompetencia;

    @Override
    public int hashCode() {
        return Objects.hash(idColaborador, idCompetencia);
    }
}
