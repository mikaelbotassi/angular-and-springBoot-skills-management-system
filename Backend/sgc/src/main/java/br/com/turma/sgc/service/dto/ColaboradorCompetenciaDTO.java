package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ColaboradorCompetenciaDTO implements Serializable {

    @NotNull
    private Integer idCompetencia;
    private String nomeCompetencia;

    @NotNull
    private Integer nivel;

}
