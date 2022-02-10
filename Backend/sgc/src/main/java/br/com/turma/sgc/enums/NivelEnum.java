package br.com.turma.sgc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum NivelEnum{

    NIVEL1(1, "Júnior"),
    NIVEL2(2, "Pleno"),
    NIVEL3(3, "Sênior).");

    private Integer id;
    private String nome;

    public static NivelEnum PegaEnumPorNome(String nivel) {
        for(NivelEnum value : NivelEnum.values()){
            if(Objects.equals(value.getNome(), nivel)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public static NivelEnum pegaEnumPorId(Integer id){
        for(NivelEnum value : NivelEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

}
