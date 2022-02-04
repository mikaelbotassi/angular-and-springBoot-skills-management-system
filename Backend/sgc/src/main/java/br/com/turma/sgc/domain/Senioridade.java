package br.com.turma.sgc.domain;

import ch.qos.logback.classic.db.names.TableName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "senioridade")
public class Senioridade implements Serializable {

    @Id
    private int id;
    @Column(name = "nome")
    private String nome;

}
