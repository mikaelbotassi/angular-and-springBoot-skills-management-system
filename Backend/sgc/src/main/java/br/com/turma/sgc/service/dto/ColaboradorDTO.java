package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "O nome do Colaborador é obrigatório!")
    private String nome;

    @NotBlank(message = "O sobrenome do Colaborador é obrigatório!")
    private String sobrenome;

    @NotBlank(message = "O CPF do Colaborador é obrigatório!")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos")
    private String cpf;

    private byte[] foto;

    @NotBlank(message = "O E-mail do Colaborador é obrigatório!")
    private String email;

    @NotNull(message = "A data de nascimento do Colaborador é obrigatória!")
    private LocalDate dataNascimento;

    @NotNull(message = "A data de admissão do Colaborador é obrigatória!")
    private LocalDate dataAdmissao;

    private String nomeSenioridade;

    @NotNull(message = "A senioridade do Colaborador é obrigatória")
    private Integer idSenioridade;

}
