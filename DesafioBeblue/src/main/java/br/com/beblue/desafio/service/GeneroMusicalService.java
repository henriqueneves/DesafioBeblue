package br.com.beblue.desafio.service;

import br.com.beblue.desafio.model.GeneroMusical;
import br.com.beblue.desafio.model.Venda;
import br.com.beblue.desafio.repository.GeneroMusicalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author henri
 */
@Service
public class GeneroMusicalService {
    
    @Autowired
    private GeneroMusicalRepository generoMusicalRepository;
    
    public GeneroMusical buscarPorNome(String nome){
        return generoMusicalRepository.findOneByNome(nome);
    }
    
}
