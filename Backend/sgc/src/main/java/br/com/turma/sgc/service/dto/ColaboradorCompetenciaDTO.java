package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ColaboradorCompetenciaDTO implements Serializable {
    private Integer id;

    private String colaboradorId;
    private String competenciaId;
    private String nivel;
}
