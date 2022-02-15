package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurmaFormacaoDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate inicio;
    private LocalDate termino;
    private Integer id_status;
}