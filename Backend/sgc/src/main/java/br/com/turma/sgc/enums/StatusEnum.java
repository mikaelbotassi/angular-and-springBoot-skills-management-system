package br.com.turma.sgc.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum StatusEnum {

    PENDENTE(0, "Pendente"),
    INICIADA(1, "Iniciada"),
    CONCLUIDA(2, "Concluida");

    private int id;
    private String nome;

    StatusEnum(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public static StatusEnum findByName(String status) {
        for(StatusEnum value : StatusEnum.values()){
            if(Objects.equals(value.getNome(), status)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public static StatusEnum valueOf(int id){
        for(StatusEnum value : StatusEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}
