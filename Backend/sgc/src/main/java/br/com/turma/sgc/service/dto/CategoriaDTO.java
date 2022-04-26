package br.com.turma.sgc.service.dto;

import br.com.turma.sgc.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable {
    private Integer id;
    private String descricao;

    public CategoriaDTO(Integer id) {
        this.id = id;
    }
}
