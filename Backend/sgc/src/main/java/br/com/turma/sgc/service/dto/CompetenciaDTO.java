package br.com.turma.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetenciaDTO implements Serializable {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer categoriaId;
    private String categoriaNome;
}
