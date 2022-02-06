package br.com.turma.sgc.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum SenioridadeEnum {

    ESTAGIARIO(0, "Estagiário"),
    JUNIOR(1, "Júnior"),
    PLENO(2, "Pleno"),
    SENIOR(3, "Sênior");

    private int id;
    private String nome;

    SenioridadeEnum(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public static SenioridadeEnum findByName(String senioridade) {
        for(SenioridadeEnum value : SenioridadeEnum.values()){
            if(Objects.equals(value.getNome(), senioridade)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public SenioridadeEnum valueOf(int id){
        for(SenioridadeEnum value : SenioridadeEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}
