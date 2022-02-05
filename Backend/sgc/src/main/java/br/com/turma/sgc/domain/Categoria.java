package br.com.turma.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data // cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@AllArgsConstructor //cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor //cria automaticamente um construtor vazio (sem argumentos).
@Builder

@Entity
@Table (name = "categoria")
public class Categoria implements Serializable {

    @Id //identifica como primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY) //identificar como a coluna id será gerada
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;
}
