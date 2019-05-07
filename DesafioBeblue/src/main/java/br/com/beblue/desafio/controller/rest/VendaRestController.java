package br.com.beblue.desafio.controller.rest;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.Venda;
import br.com.beblue.desafio.service.DiscoService;
import br.com.beblue.desafio.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author henri
 */

@RestController
@RequestMapping(value = "api/venda")
public class VendaRestController {
      
    @Autowired
    private VendaService vendaService;
    
    @PostMapping("nova")
    public String novaVenda(@RequestBody Venda venda) {
        vendaService.novo(venda);
        return "Sucesso! Venda cadastrada.";
    }
    
}
