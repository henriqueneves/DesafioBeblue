package br.com.beblue.desafio.controller.rest;

import br.com.beblue.desafio.dto.ResponseDTO;
import br.com.beblue.desafio.model.Venda;
import br.com.beblue.desafio.service.VendaService;
import br.com.beblue.desafio.util.messages.MensagemError;
import br.com.beblue.desafio.util.messages.Messages;
import br.com.beblue.desafio.util.TryCatchDefaultRest;
import br.com.beblue.desafio.util.filters.FiltroVenda;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    private Messages messages;

    /* Cadastra nova venda */
    @PostMapping("nova")
    public ResponseEntity<ResponseDTO> novaVenda(@Valid @RequestBody Venda venda, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    new ResponseDTO(venda)
                            .comMensagem(MensagemError.resultHasErros())
                            .comErros(messages.get(result))
            );
        };

        return new TryCatchDefaultRest(venda, "Cadastro realizado com sucesso")
                .execute(() -> vendaService.novo(venda));
    }

    /* Retorna todas as vendas */
    @GetMapping
    public List<Venda> buscarTodos() {
        return vendaService.visualizarTodos();
    }

    /* Busca vendas filtrando e ordenando por data */
    @GetMapping("/buscar")
    public Page<Venda> buscar(@Valid FiltroVenda vendaFiltro, BindingResult result) {
        return vendaService.buscarPorData(vendaFiltro);

    }

    /* Busca venda pelo identificador */
    @GetMapping("/buscar/{id}")
    public Venda buscarPorId(Venda venda) {
        return vendaService.procurar(venda);
    }

}
