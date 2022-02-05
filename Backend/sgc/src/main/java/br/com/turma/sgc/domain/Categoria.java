package br.com.turma.sgc.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor //cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor //cria automaticamente um construtor vazio (sem argumentos).

//@Data cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Getter
@Setter

@Entity
@Table (name = "categoria")
public class Categoria implements Serializable {

    @Id //identifica como primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY) //identificar como a coluna id será gerada
    private int id;

    @Column(name = "nome")
    private String name;
}
