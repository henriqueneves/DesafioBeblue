package br.com.beblue.desafio.repository;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.GeneroMusical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author henri
 */

@Repository
public interface DiscoRepository extends CrudRepository<Disco, Long>{
    
    @Query("FROM Disco d WHERE generoMusical = :genero")
    Page<Disco> buscarPorGenero(@Param("genero") GeneroMusical genero, Pageable pageable);
    
}
