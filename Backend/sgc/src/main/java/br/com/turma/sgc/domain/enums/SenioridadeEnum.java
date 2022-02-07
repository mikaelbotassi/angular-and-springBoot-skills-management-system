package br.com.turma.sgc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum SenioridadeEnum{

    ESTAGIARIO(1, "Estagiário"),
    JUNIOR(2, "Júnior"),
    PLENO(3, "Pleno"),
    SENIOR(4, "Sênior");

    private int id;
    private String nome;

    public static SenioridadeEnum PegaEnumPorNome(String senioridade) {
        for(SenioridadeEnum value : SenioridadeEnum.values()){
            if(Objects.equals(value.getNome(), senioridade)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public static SenioridadeEnum PegaEnumPorId(int id){
        for(SenioridadeEnum value : SenioridadeEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}
