package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categoria implements Serializable {
    @Id
    private Integer id;
    @Column(name = "nome")
    private String nome;
}
