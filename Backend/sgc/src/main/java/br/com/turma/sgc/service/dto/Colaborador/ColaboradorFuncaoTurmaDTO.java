package br.com.turma.sgc.service.dto.Colaborador;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ColaboradorFuncaoTurmaDTO implements Serializable {

    private String colaboradorNome;
    private String nomeCompetencia;

}
