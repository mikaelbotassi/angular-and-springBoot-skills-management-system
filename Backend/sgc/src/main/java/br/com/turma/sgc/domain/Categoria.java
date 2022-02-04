package br.com.turma.sgc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "categoria")
public class Categoria implements Serializable {

    @Id
    private int id;

    @Column(name = "nome")
    private String nome;
}
