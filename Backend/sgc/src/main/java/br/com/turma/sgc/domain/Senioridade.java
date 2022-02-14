package br.com.turma.sgc.domain;

import br.com.turma.sgc.enums.SenioridadeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class Senioridade implements Serializable {

    @Id
    private Integer id;

    @Column(name = "nome")
    private String nome;

    public Senioridade(SenioridadeEnum senioridade){
        this.id = senioridade.getId();
        this.nome = senioridade.getNome();
    }

}
