package br.com.turma.sgc.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorBuscaDTO {

    @JsonProperty("nomeColaborador")
    private String nomeColaborador;

    @JsonProperty("sobrenomeColaborador")
    private String sobrenomeColaborador;

    @JsonProperty("dataNascimento")
    private LocalDate dataNascimento;

    @JsonProperty("dataAdmissao")
    private LocalDate dataAdmissao;
}
