package br.com.beblue.desafio.repository;

import br.com.beblue.desafio.model.Cashback;
import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.GeneroMusical;
import java.time.DayOfWeek;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author henri
 */

@Repository
public interface CashbackRepository extends CrudRepository<Cashback, Long>{
    
    @Query("FROM Cashback c WHERE c.id.generoMusical = :genero and c.id.diaDaSemana = :diaDaSemana")
    public Cashback buscarPorGenero(@Param("genero") GeneroMusical genero, @Param("diaDaSemana") DayOfWeek diaDaSemana);
}
