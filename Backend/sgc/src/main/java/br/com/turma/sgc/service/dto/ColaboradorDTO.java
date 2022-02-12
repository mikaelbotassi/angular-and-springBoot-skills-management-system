package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "O nome do Colaborador é obrigatório!")
    private String nomeColaborador;

    @NotBlank(message = "O sobrenome do Colaborador é obrigatório!")
    private String sobrenomeColaborador;

    @NotBlank(message = "O CPF do Colaborador é obrigatório!")
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
