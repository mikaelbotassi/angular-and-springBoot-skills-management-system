package br.com.turma.sgc.repository;
import br.com.turma.sgc.domain.Senioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenoridadeRepository extends JpaRepository<Senioridade, Integer> {

}
