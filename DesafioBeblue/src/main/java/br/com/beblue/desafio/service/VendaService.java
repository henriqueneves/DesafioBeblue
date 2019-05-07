package br.com.beblue.desafio.service;

import br.com.beblue.desafio.model.Venda;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author henri
 */
@Service
public class VendaService implements CrudService<Venda>  {

    @Override
    public void novo(Venda model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Venda model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> visualizarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Venda procurar(Venda model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
