package br.com.beblue.desafio.repository;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.Venda;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author henri
 */
public interface VendaRepository extends CrudRepository<Venda, Long>{
    
}
