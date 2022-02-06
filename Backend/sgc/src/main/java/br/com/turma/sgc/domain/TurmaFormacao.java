package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TURMA_FORMACAO")
public class TurmaFormacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_TURMA_FORMACAO")
    @SequenceGenerator(name = "SQ_TURMA_FORMACAO", sequenceName = "SQ_TURMA_FORMACAO", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    String nome;
    @Column(name = "descricao")
    String descricao;
    @Column(name = "id_diciplinas_instrutores")
    Integer diciplinas_instrutores;
    @Column(name = "inicio")
    Date inicio;
    @Column(name = "termino")
    java.util.Date termino;
    @Column(name = "id_status")
    Integer status;
}
