package br.com.turma.sgc.domain;

import br.com.turma.sgc.enums.CategoriaEnum;
import br.com.turma.sgc.enums.NivelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turma_colaborador_competencia")
@Getter
@Setter
public class TurmaColaboradorCompetencia implements Serializable {

    @EmbeddedId
    private TurmaColaboradorCompetenciaPK id;

    @Enumerated(EnumType.ORDINAL)
    private NivelEnum nivel;

    public TurmaColaboradorCompetencia(){
        this.id = new TurmaColaboradorCompetenciaPK();
    }
}
