package br.com.turma.sgc.service.dto;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TurmaColaboradorCompetenciaDTO implements Serializable {

    private Integer turmaId;

    private Integer colaboradorId;

    private Integer competenciaId;

}
