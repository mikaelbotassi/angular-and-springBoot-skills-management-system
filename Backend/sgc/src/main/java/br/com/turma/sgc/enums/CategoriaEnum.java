package br.com.turma.sgc.enums;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public enum CategoriaEnum implements Serializable {

    BACKEND(1, "Backend"),
    FRONTEND(2, "Frontend"),
    BANCO(3, "Banco"),
    ARQUITETURA(4, "Arquitetura"),
    METODOLOGIA(5, "Metodologia"),
    AGIL(6, "Ágil"),
    TESTES(7, "Testes"),
    DEVOPS(8, "Devops"),
    LIDERANCA(9, "Liderança");

    private int id;
    private String nome;

    CategoriaEnum(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public static CategoriaEnum findByName(String categoria) {
        for(CategoriaEnum value : CategoriaEnum.values()){
            if(Objects.equals(value.getNome(), categoria)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public static CategoriaEnum valueOf(int id){
        for(CategoriaEnum value : CategoriaEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}

