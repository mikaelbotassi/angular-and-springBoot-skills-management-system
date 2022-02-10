package br.com.turma.sgc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CategoriaEnum {

    BACKEND(1, "Backend"),
    FRONTEND(2, "Frontend"),
    BANCO(3, "Banco"),
    ARQUITETURA(4, "Arquitetura"),
    METODOLOGIA(5, "Metodologia"),
    AGIL(6, "Ágil"),
    TESTES(7, "Testes"),
    DEVOPS(8, "Devops"),
    LIDERANCA(9, "Liderança");

    private Integer id;
    private String nome;

    public static CategoriaEnum PegaEnumPorId(Integer id){
        for(CategoriaEnum value : CategoriaEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}

