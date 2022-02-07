package br.com.turma.sgc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "senioridade")
public class Status {

    @Id
    private int id;

    @Column(name = "nome")
    private String nome;

}
