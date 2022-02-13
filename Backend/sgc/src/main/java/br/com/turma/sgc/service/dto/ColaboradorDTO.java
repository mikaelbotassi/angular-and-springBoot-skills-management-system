package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String cpf;

    private byte[] foto;

    @Email
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private LocalDate dataAdmissao;

    private String nomeSenioridade;

    @NotNull
    private Integer idSenioridade;

    private List<ColaboradorCompetenciaDTO> competenciasDTO;

}
