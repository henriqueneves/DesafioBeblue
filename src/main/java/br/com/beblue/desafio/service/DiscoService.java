package br.com.beblue.desafio.service;

import br.com.beblue.desafio.exception.SystemRuntimeException;
import br.com.beblue.desafio.exception.dados.DuplicateDataException;
import br.com.beblue.desafio.exception.sistema.NotFoundException;
import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.GeneroMusical;
import br.com.beblue.desafio.repository.DiscoRepository;
import br.com.beblue.desafio.repository.GeneroMusicalRepository;
import br.com.beblue.desafio.util.filters.FiltroDisco;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Disco novo(Disco disco) {
        try {
            discoRepository.save(disco);
            return disco;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateDataException("Erro ao criar disco: outro disco com mesmo código já foi cadastrado.");
        }
    }

    @Override
    public List<Disco> visualizarTodos() {
        return (List) discoRepository.findAll();
    }

    public Disco procurar(Disco disco) {
        Optional<Disco> discoOptional = discoRepository.findById(disco.getId());
        if (discoOptional.isPresent()) {
            return discoOptional.get();
        }
        throw new NotFoundException("Disco não cadastrado no sistema");
    }

    public Page<Disco> buscarPorGenero(FiltroDisco filtroDisco) {
        PageRequest pageRequest = PageRequest.of(filtroDisco.getPagina(), filtroDisco.getTamanho(), filtroDisco.getDirection(), filtroDisco.getOrdenarPor());
        return discoRepository.buscarPorGenero(generoMusicalService.buscarPorNome(filtroDisco.getGeneroMusical()), pageRequest);
    }

    @Transactional
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
