package br.com.beblue.desafio.repository;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.GeneroMusical;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author henri
 */

@Repository
public interface GeneroMusicalRepository extends CrudRepository<GeneroMusical, Long>{
    
    public GeneroMusical findOneByNome(String nome);
    
}
