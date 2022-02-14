package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaDTO implements Serializable {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer categoriaId;
    private String nomeCategoria;
}
