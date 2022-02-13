package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private byte[] foto;

    private String email;

    private LocalDate dataNascimento;

    private LocalDate dataAdmissao;

    private String nomeSenioridade;

    private Integer idSenioridade;

}
