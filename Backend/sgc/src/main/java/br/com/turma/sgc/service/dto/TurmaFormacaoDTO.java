package br.com.turma.sgc.service.dto;


import br.com.turma.sgc.domain.Colaborador;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


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