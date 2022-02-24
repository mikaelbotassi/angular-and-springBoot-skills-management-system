package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class CadastrarColaboradorDTO {

    private String nome;

    private String sobrenome;

    private String cpf;

    private byte[] foto;

    private String email;

    private LocalDate dataNascimento;

    private LocalDate dataAdmissao;

    private Integer idSenioridade;


    private List<CadastrarCompetenciaDTO> competencia;

    public CadastrarColaboradorDTO() {
        this.competencia = new ArrayList<CadastrarCompetenciaDTO>() {
        };
    }
}
