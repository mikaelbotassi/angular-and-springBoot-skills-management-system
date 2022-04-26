package br.com.turma.sgc.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SelectItemDTO implements Serializable {

    private Integer value;
    private String label;


}