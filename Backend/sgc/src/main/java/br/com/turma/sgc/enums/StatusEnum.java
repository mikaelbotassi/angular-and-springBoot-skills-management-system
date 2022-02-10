package br.com.turma.sgc.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum StatusEnum {

    PENDENTE(1, "Pendente"),
    INICIADA(2, "Iniciada"),
    CONCLUIDA(3, "Concluida");

    private Integer id;
    private String nome;

    StatusEnum(Integer id, String nome){
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

    public static StatusEnum valueOf(Integer id){
        for(StatusEnum value : StatusEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}
