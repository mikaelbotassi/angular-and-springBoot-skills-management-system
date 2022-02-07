package br.com.turma.sgc.domain;

import br.com.turma.sgc.domain.pk.Colaborador_CompetenciaPK;
import br.com.turma.sgc.enums.NivelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "colaborador_competencia")
public class Colaborador_Competecia implements Serializable {

    @EmbeddedId
    private Colaborador_CompetenciaPK id;

    @ManyToOne
    @MapsId("idColborador")
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @MapsId("idCompetencia")
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

    @Enumerated(EnumType.ORDINAL)
    private NivelEnum nivel;

    public Colaborador_Competecia(){}

    public Colaborador_Competecia(Colaborador_CompetenciaPK id, Colaborador colaborador, Competencia competencia) {
        this.id = id;
        this.colaborador = colaborador;
        this.competencia = competencia;
    }
}
