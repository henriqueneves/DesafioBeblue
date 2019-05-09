package br.com.beblue.desafio.controller.rest;

import br.com.beblue.desafio.dto.ResponseDTO;
import br.com.beblue.desafio.exception.dados.InvalidValueException;
import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.service.DiscoService;
import br.com.beblue.desafio.util.TryCatchDefaultRest;
import br.com.beblue.desafio.util.filters.FiltroDisco;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author henri
 */
@RestController
@RequestMapping(value = "api/disco")
public class DiscoRestController {

    @Autowired
    private DiscoService discoService;

    /* Importa os discos através da API do Spotify */
    @GetMapping("importar")
    public ResponseEntity<ResponseDTO> importarDiscos() {
        return new TryCatchDefaultRest("Importação realizada com sucesso.")
                .execute(() -> discoService.importarDiscos());
    }

    /* Retorna todos os discos */
    @GetMapping
    public List<Disco> buscarTodos() {
        return discoService.visualizarTodos();
    }

    /* Busca de forma paginada os discos cadastrados no sistema, filtrando por genero e ordenando por título */
    @GetMapping("/buscar")
    public Page<Disco> buscar(@Valid FiltroDisco filtroDisco, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidValueException("Erro nos parâmetros: " + result.toString());
        }
        return discoService.buscarPorGenero(filtroDisco);

    }

    /* Busca um único disco pelo seu identificador */
    @GetMapping("/buscar/{id}")
    public Disco buscarPorId(Disco disco) {
        return discoService.procurar(disco);
    }

}
