package br.com.turma.sgc.service.dto.Colaborador;

import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorCompetenciaDTO implements Serializable {

    private Integer colaboradorId;

    private Integer competenciaId;

    private Integer nivel;

    private ColaboradorCompetenciaPK id;


    public ColaboradorCompetenciaDTO(ColaboradorCompetenciaPK id, Integer colaboradorId, Integer competenciaId,Integer nivel) {
        this.colaboradorId = colaboradorId;
        this.competenciaId = competenciaId;
        this.id = id;
        this.nivel = nivel;
    }
}
