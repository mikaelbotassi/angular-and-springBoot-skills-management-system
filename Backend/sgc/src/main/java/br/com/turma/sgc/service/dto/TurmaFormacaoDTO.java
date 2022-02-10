package br.com.turma.sgc.service.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
public class TurmaFormacaoDTO implements Serializable {



    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate inicio;
    private LocalDate termino;
    private Integer statusId;
}