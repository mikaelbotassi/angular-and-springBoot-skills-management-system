package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TurmaColaboradorCompetenciaDTO {

    @NotNull
    private Integer idTurma;
    private String nomeTurma;

    @NotNull
    private Integer idColaborador;
    private String nomeColaborador;

    @NotNull
    private Integer idCompetencia;
    private String nomeCompetencia;
}
