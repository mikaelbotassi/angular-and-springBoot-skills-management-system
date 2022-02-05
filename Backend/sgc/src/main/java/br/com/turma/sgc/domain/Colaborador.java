package br.com.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "colaborador")
public class Colaborador implements Serializable {

    @Id
    private int id;
    @Column(name = "nome_colaborador")
    private String nomeColaborador;
    @Column(name = "sobrenome_colaborador")
    private String sobrenomeColaborador;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "data_nascimento")
    private Instant dataNascimento;
    @Column(name = "data_admissao")
    private Instant dataAdmissao;

}
