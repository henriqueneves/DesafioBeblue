package br.com.beblue.desafio.controller.rest;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.Venda;
import br.com.beblue.desafio.model.VendaDisco;
import br.com.beblue.desafio.service.VendaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping
    public String gerarVendas(){
        Venda venda = new Venda();
        VendaDisco vd1 = new VendaDisco();
        Disco d1 = new Disco();
        d1.setId(new Long(2));
        vd1.setDisco(d1);
        List<VendaDisco> lvd = new ArrayList();
        lvd.add(vd1);
        venda.setVendaDiscos(lvd);
        vendaService.novo(venda);
        return "Sucesso! Vendas geradas.";
    }
    
    @GetMapping("/buscar")
    public Page<Venda> buscar(
            @RequestParam("data-inicio") @DateTimeFormat(pattern="dd/MM/yyyy") Date dataInicio,
            @RequestParam("data-fim") @DateTimeFormat(pattern="dd/MM/yyyy") Date dataFim,
            @RequestParam(value = "pagina", required = false, defaultValue = "0") int page,
            @RequestParam(value = "tamanho", required = false, defaultValue = "10") int size) {
        return vendaService.buscarPorData(dataInicio, dataFim, page, size);

    }
    
    @GetMapping("/buscar/{id}")
    public Venda buscarPorId(Venda venda){
        return vendaService.procurar(venda);
    }
    
}
