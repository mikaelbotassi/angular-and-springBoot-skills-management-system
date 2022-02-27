package br.com.turma.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ColaboradorListDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String nomeSenioridade;

}
