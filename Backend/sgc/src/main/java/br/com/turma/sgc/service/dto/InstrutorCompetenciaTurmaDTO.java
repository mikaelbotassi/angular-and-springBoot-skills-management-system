package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstrutorCompetenciaTurmaDTO {

    private String nomeTurma;
    private String nomeColaborador;
    private String nomeCompetencia;
    private Integer nivelCompetencia;

    public InstrutorCompetenciaTurmaDTO() {
        this.nivelCompetencia = 3;
    }
}
