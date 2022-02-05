package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
//<>primeiro é a entidade JPA que representa a tabela e o segundo é o tipo da chave primária

    public void save(Categoria obj) {

    }
    public Categoria findById (Integer id) {

    }

    public List<Categoria> findAll() {

    }

}
