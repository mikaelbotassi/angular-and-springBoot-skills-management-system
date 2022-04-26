package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorListDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaColaboradorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query("select new br.com.turma.sgc.service.dto.Competencia.CompetenciaColaboradorDTO(nome, sobrenome) " +
            "from Colaborador " +
            "where id = :id")
    CompetenciaColaboradorDTO buscarColaborador(@Param("id") Integer id);

    @Query("select new br.com.turma.sgc.service.dto.Colaborador.ColaboradorListDTO(id, nome, sobrenome, senioridade.nome) " +
            " from Colaborador where ativo = true")
    List<ColaboradorListDTO> obterTodos();

    @Query("select c from Colaborador c where c.cpf = :cpf")
    Optional<Colaborador> buscarPorCPF(@Param("cpf") String cpf);

    @Query("select c from Colaborador c where c.email = :email")
    Optional<Colaborador> buscarPorEmail(@Param("email") String email);

    @Modifying
    @Query(value = "update Colaborador c set ativo = false where c.id = :idColaborador ")
    void desativarColaborador(@Param("idColaborador") Integer idColaborador);
}
