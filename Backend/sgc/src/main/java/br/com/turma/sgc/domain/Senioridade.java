package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "senioridade")
@Getter
@Setter
public class Senioridade implements Serializable {

    @Id
    private Integer id;

    @Column(name = "nome")
    private String nome;
}
