/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.service;

import br.com.beblue.desafio.exception.dados.DuplicateDataException;
import br.com.beblue.desafio.exception.sistema.NotFoundException;
import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.repository.DiscoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author henri
 */

@Service
public class DiscoService implements CrudService<Disco>{

    @Autowired
    private DiscoRepository discoRepository;
    
    @Autowired
    private SpotifyService spotifyService;
    
    @Value("${discos.importador.quantidade}")
    private Integer quantidadeDiscos;

    @Override
    public void novo(Disco disco) {
        try {
            discoRepository.save(disco);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateDataException("Outra cidade com mesmo nome e estado já foi cadastrada.");
        }
    }

    @Override
    public void editar(Disco disco) {
        try {
            discoRepository.save(disco);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateDataException("Outra cidade com mesmo nome e estado já foi cadastrada.");
        }
    }

    @Override
    public List<Disco> visualizarTodos() {
        return (List) discoRepository.findAll();
    }

    @Override
    public Disco carregar(Disco disco) {
        return find(disco);
    }

    public Disco find(Disco disco) {
        Optional<Disco> cidadeOptional = discoRepository.findById(disco.getId());

        throw new NotFoundException("Cidade não cadastrada no sistema");
    }
    
    public String importarDiscos(){
        spotifyService.importarDiscosPorGeneroEQuantidade(null, quantidadeDiscos);
        return "";
    }
    
}
