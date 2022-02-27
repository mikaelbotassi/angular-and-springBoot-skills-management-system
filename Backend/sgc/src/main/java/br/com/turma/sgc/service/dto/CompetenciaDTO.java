package br.com.turma.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetenciaDTO implements Serializable {

    private Integer id;
    @NotNull(message = "NOME INVÁLIDO! Digite algum nome.")
    @NotBlank(message = "NOME INVÁLIDO! Digite algum nome.")
    private String nome;
    @NotNull(message = "DESCRIÇÃO INVÁLIDA! Digite alguma descrição.")
    @NotBlank(message = "DESCRIÇÃO INVÁLIDA! Digite alguma descrição.")
    private String descricao;
    @NotNull(message = "CATEGORIA INVÁLIDA! Insira alguma categoria.")
    private CategoriaDTO categoria;
}
