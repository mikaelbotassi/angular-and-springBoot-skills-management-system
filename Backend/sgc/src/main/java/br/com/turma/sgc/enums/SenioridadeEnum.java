package br.com.turma.sgc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SenioridadeEnum implements Serializable {

    ESTAGIARIO(1, "Estagiário"),
    JUNIOR(2, "Júnior"),
    PLENO(3, "Pleno"),
    SENIOR(4, "Sênior");

    private int id;
    private String nome;

    public static SenioridadeEnum buscarPorNome(String senioridade) {
        for(SenioridadeEnum value : SenioridadeEnum.values()){
            if(Objects.equals(value.getNome(), senioridade)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public static SenioridadeEnum retornarValorPorId(Integer id){
        for(SenioridadeEnum value : SenioridadeEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}
