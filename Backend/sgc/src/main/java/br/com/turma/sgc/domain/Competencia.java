package br.com.turma.sgc.domain;

import ch.qos.logback.classic.db.names.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "competencia")
@Getter
@Setter
public class Competencia implements Serializable {

    @Id
    @SequenceGenerator(name = "serial_competencia")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    /*@Column(name= "id_categoria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;*/
}