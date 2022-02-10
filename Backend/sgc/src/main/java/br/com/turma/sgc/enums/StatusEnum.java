package br.com.turma.sgc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    PENDENTE(1, "Pendente"),
    INICIADA(2, "Iniciada"),
    CONCLUIDA(3, "Concluida");

    private Integer id;
    private String nome;

    public static StatusEnum pegaEnumPorNome(String status) {
        for(StatusEnum value : StatusEnum.values()){
            if(Objects.equals(value.getNome(), status)){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }

    public static StatusEnum pegaEnumPorId(Integer id){
        for(StatusEnum value : StatusEnum.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}
