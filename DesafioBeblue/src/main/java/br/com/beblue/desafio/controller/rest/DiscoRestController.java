package br.com.beblue.desafio.controller.rest;

import br.com.beblue.desafio.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
