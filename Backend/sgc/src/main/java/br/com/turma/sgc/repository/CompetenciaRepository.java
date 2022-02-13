package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

//    //Query para pegar as competências de determinada categoria.(Layla)
//    @Query("select cp from Competencia cp inner join Categoria c" +
//            "on cp.competencia.id = c.categoria.id " +
//            "and c.categoria.id = :categoriaId")
//    List<Competencia> buscarCompetenciaPorCategoria(@Param("categoriaId") Integer categoriaId);
}
