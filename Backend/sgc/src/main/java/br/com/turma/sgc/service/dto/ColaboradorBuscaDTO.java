package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorBuscaDTO implements Serializable {

    private String nomeColaborador;

    private String sobrenomeColaborador;

    private LocalDate dataNascimento;

    private LocalDate dataAdmissao;

    private String nomeSenioridade;
}
