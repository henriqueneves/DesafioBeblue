package br.com.beblue.desafio.repository;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author henri
 */

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long>{
    
}
