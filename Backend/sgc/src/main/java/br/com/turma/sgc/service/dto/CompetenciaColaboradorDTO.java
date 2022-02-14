package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompetenciaColaboradorDTO implements Serializable {

    private String nome;
    private String sobrenome;

    private List<CompetenciaDTO> competenciasDTO = new ArrayList<>();

    public CompetenciaColaboradorDTO(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
}
