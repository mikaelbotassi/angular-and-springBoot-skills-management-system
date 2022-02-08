package br.com.turma.sgc.service.dto;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.domain.enums.NivelEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ColaboradorCompetenciaDTO implements Serializable {
    private Colaborador colaborador;
    private Competencia competencia;
    private NivelEnum nivel;
}
