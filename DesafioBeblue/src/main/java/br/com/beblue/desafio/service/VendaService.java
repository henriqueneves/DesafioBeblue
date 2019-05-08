package br.com.beblue.desafio.service;

import br.com.beblue.desafio.exception.SystemRuntimeException;
import br.com.beblue.desafio.exception.sistema.NotFoundException;
import br.com.beblue.desafio.model.Cashback;
import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.Venda;
import br.com.beblue.desafio.model.VendaDisco;
import br.com.beblue.desafio.repository.CashbackRepository;
import br.com.beblue.desafio.repository.VendaRepository;
import br.com.beblue.desafio.util.DatasUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author henri
 */
@Service
public class VendaService implements CrudService<Venda> {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private CashbackRepository cashbackRepository;

    @Autowired
    private DiscoService discoService;

    @Override
    @Transactional
    public void novo(Venda venda) {
        try {
            venda.setRegistroDaVenda(new Date());
            venda.setVendaDiscos(calculaCashbackIndividual(venda));
            venda.calcularValores();
            vendaRepository.save(venda);
        } catch (Exception e) {
            throw new SystemRuntimeException("Erro ao salvar nova venda: " + e.getMessage());
        }
    }

    @Override
    public List<Venda> visualizarTodos() {
        return (List) vendaRepository.findAll();
    }

    @Override
    public Venda procurar(Venda venda) {
         Optional<Venda> vendaOptional = vendaRepository.findById(venda.getId());
        if(vendaOptional.isPresent()){
            return vendaOptional.get();
        }
        throw new NotFoundException("Venda não cadastrada no sistema");
    }

    private List<VendaDisco> calculaCashbackIndividual(Venda venda) {
        List<VendaDisco> auxiliar = new ArrayList();
        for (VendaDisco vendaDisco : venda.getVendaDiscos()) {
            VendaDisco novaVendaDisco = new VendaDisco(discoService.procurar(vendaDisco.getDisco()));
            novaVendaDisco.setValorCashback(carregaCashback(novaVendaDisco.getDisco(), venda.getRegistroDaVenda()));
            auxiliar.add(novaVendaDisco);
        }
        return auxiliar;
    }

    private BigDecimal carregaCashback(Disco disco, Date data) {
        Cashback cashback = cashbackRepository.buscarPorGenero(disco.getGeneroMusical(), new DatasUtil().pegaDiaDaSemana(data));
        return disco.getPreco().multiply(new BigDecimal(cashback.getPorcentagem()).divide(new BigDecimal(100)));
    }
    
    public Page<Venda> buscarPorData(Date dataInicio, Date dataFim,  int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "registroDaVenda");
        return vendaRepository.buscarPorData(dataInicio, dataFim, pageRequest);
    }
}
