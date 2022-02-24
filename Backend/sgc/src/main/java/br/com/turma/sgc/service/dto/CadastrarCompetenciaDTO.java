package br.com.turma.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CadastrarCompetenciaDTO {
    private Integer id;
    private Integer nivel;
    private String nome;

    public CadastrarCompetenciaDTO(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

}
