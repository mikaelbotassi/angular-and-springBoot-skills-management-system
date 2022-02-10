package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InstrutorCompetenciaTurmaDTO  implements Serializable {

    private Integer NomeColaborador;
    private String NomeCompetencia;
    private String Nivel;

}
