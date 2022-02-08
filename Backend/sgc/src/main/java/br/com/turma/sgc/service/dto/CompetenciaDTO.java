package br.com.turma.sgc.service.dto;

import br.com.turma.sgc.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaDTO implements Serializable {
    private Integer id;
    private String nome;
    private String descricao;
    private Categoria categoria;
}
