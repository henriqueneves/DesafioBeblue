/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.service;

import br.com.beblue.desafio.exception.SystemRuntimeException;
import br.com.beblue.desafio.exception.dados.DuplicateDataException;
import br.com.beblue.desafio.exception.sistema.NotFoundException;
import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.GeneroMusical;
import br.com.beblue.desafio.repository.DiscoRepository;
import br.com.beblue.desafio.repository.GeneroMusicalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

/**
 *
 * @author henri
 */
@Service
public class DiscoService implements CrudService<Disco> {

    @Autowired
    private DiscoRepository discoRepository;

    @Autowired
    private GeneroMusicalRepository generoMusicalRepository;

    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private GeneroMusicalService generoMusicalService;

    @Value("${discos.importador.quantidade}")
    private Integer quantidadeDiscos;

    @Override
    public void novo(Disco disco) {
        try {
            discoRepository.save(disco);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateDataException("Outro disco com mesmo código já foi cadastrado.");
        }
    }

    @Override
    public void editar(Disco disco) {
        try {
            discoRepository.save(disco);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateDataException("Outro disco com mesmo código já foi cadastrado.");
        }
    }

    @Override
    public List<Disco> visualizarTodos() {
        return (List) discoRepository.findAll();
    }

    public Disco procurar(Disco disco) {
        Optional<Disco> discoOptional = discoRepository.findById(disco.getId());

        throw new NotFoundException("Disco não cadastrado no sistema");
    }

    public Page<Disco> buscarPorGenero(String genero, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
        return discoRepository.buscarPorGenero(generoMusicalService.buscarPorNome(genero.toUpperCase()), pageRequest);
    }

    public String importarDiscos() {
        try {
            List<Disco> discos = spotifyService.getDiscosPorGeneroEQuantidade(generoMusicalRepository.findAll(), quantidadeDiscos);
            discoRepository.saveAll(discos);
            return "Sucesso ao importar e salvar " + discos.size() + " discos.";
        } catch (Exception e) {
            throw new SystemRuntimeException("Erro ao importar os discos: " + e.getMessage());
        }
    }

}
