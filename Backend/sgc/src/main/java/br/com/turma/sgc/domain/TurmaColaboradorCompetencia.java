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

    @Enumerated(EnumType.ORDINAL)
    private NivelEnum nivel;

    public TurmaColaboradorCompetencia(){
        this.id = new TurmaColaboradorCompetenciaPK();
    }
}
