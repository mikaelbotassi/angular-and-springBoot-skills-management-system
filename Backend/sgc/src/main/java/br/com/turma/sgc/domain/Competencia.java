package br.com.turma.sgc.domain;

import ch.qos.logback.classic.db.names.TableName;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "competencia")
@Getter
@Setter
public class Competencia implements Serializable {

    @Id
    @SequenceGenerator(sequenceName = "serial_competencia", name = "serial_competencia")
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE)*/
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name="id_categoria", nullable=false)
    private Categoria categoria;
}