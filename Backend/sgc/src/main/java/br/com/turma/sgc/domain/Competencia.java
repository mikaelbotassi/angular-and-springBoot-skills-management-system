package br.com.turma.sgc.domain;

import br.com.turma.sgc.domain.enums.CategoriaEnum;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COMPE")
    @SequenceGenerator(name = "SQ_COMPE", sequenceName = "serial_competencia", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}