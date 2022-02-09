package br.com.turma.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurmaColaboradorCompetenciaDTO implements Serializable {

    private Integer idTurma;
    private String nomeTurma;

    private Integer idColaborador;
    private String nomeColaborador;

    private String sobrenomeColaborador;

    private Integer idCompetencia;
    private String nomeCompetencia;

}
