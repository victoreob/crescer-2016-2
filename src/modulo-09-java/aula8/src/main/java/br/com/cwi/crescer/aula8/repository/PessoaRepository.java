package br.com.cwi.crescer.aula8.repository;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

    List<Pessoa> findByNome(String nome);
    
}
