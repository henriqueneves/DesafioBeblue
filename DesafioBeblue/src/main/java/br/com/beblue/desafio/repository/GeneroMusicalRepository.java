package br.com.beblue.desafio.repository;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.GeneroMusical;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author henri
 */
public interface GeneroMusicalRepository extends CrudRepository<GeneroMusical, Long>{
    
}
