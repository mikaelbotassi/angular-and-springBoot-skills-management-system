package br.com.turma.sgc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Senioridade {

    @Id
    private int id;

    @Column(name = "nome")
    private String nome;

}
