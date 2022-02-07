package br.com.turma.sgc.enums;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public enum NivelEnum implements Serializable {

    NIVEL1(1, "Júnior"),
    NIVEL2(2, "Pleno"),
    NIVEL3(3, "Sênior).");

    private Integer id;
    private String nome;

    NivelEnum(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public static NivelEnum findByName(String nivel) {
        for(NivelEnum value : NivelEnum.values()){
            if(Objects.equals(value.getNome(), nivel)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public static NivelEnum valueOf(int id){
        for(NivelEnum value : NivelEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

}
