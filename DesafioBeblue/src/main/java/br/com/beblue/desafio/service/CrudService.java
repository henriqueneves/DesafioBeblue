package br.com.beblue.desafio.service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author henri
 */

@Service
public interface CrudService<Model> {
    
    public Model novo(Model model);
    //editar -> não necessário
    //deletar -> não necessário
    public List<Model> visualizarTodos();
    public Model procurar(Model model);
    
}
