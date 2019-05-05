package br.com.beblue.desafio.service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author henri
 */
@Service
public interface CrudService<Model> {

    public void novo(Model model);
    public void editar(Model model);

    public List<Model> visualizarTodos();
    
    public Model carregar(Model model);
    
    public Model find(Model model);
}