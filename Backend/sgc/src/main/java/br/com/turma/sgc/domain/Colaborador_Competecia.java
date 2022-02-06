package br.com.turma.sgc.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class Colaborador_Competecia implements Serializable {

    @EmbeddedId
    private static final long ColaboradorCompetenciaPK = 1L;

    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;
}
