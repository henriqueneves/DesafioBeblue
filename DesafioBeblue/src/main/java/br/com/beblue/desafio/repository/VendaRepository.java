package br.com.beblue.desafio.repository;

import br.com.beblue.desafio.model.Venda;
import java.util.Date;
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
public interface VendaRepository extends CrudRepository<Venda, Long> {

    @Query("FROM Venda v WHERE v.registroDaVenda >= :dataInicio and v.registroDaVenda <= :dataFim")
    Page<Venda> buscarPorData(@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim, Pageable pageable);

}
