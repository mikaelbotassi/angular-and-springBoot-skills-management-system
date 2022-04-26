package br.com.turma.sgc.domain.pk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

}
