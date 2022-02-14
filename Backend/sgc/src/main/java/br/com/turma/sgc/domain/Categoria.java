package br.com.turma.sgc.domain;

import br.com.turma.sgc.enums.CategoriaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categoria")
public class Categoria implements Serializable {
    @Id
    private Integer id;
    @Column(name = "nome")
    private String nome;

    public Categoria(CategoriaEnum categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

}
