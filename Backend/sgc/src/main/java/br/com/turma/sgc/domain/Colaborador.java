package br.com.turma.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador")
public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_COLAB")
    @SequenceGenerator(name = "SQ_COLAB", sequenceName = "sq_colaborador", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "nome_colaborador")
    private String nome;

    @Column(name = "sobrenome_colaborador")
    private String sobrenome;

    @Column(name = "cpf")
    private String cpf;

    @Lob
    @Column(name = "foto")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] foto;

    @Column(name = "email")
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "id_senioridade")
    private Senioridade senioridade;

    @OneToMany(mappedBy = "colaborador")
    private Set<ColaboradorCompetencia> competencias;



}
