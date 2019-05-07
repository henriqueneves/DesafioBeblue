package br.com.beblue.desafio.controller.rest;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.service.DiscoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    
    @GetMapping("importar")
    public String importarDiscos() {
        return discoService.importarDiscos();
    }

    @GetMapping("/buscar")
    public Page<Disco> buscar(
            @RequestParam("genero") String genero,
            @RequestParam(value = "pagina", required = false, defaultValue = "0") int page,
            @RequestParam(value = "tamanho", required = false, defaultValue = "10") int size) {
        return discoService.buscarPorGenero(genero, page, size);

    }
    
    @GetMapping("/buscar/{id}")
    public Disco buscarPorId(Disco disco){
        return discoService.procurar(disco);
    }
    
    @GetMapping
    public List<Disco> buscarTodos() {
        return discoService.visualizarTodos();
    }
    
}
