package br.com.beblue.desafio.service;

import br.com.beblue.desafio.exception.SystemRuntimeException;
import br.com.beblue.desafio.exception.dados.DuplicateDataException;
import br.com.beblue.desafio.model.Cashback;
import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.Venda;
import br.com.beblue.desafio.model.VendaDisco;
import br.com.beblue.desafio.repository.CashbackRepository;
import br.com.beblue.desafio.repository.DiscoRepository;
import br.com.beblue.desafio.repository.GeneroMusicalRepository;
import br.com.beblue.desafio.repository.VendaRepository;
import br.com.beblue.desafio.util.DatasUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda procurar(Venda model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<VendaDisco> calculaCashbackIndividual(Venda venda) {
        List<VendaDisco> auxiliar = new ArrayList();
        for (VendaDisco vendaDisco : venda.getVendaDiscos()) {
            VendaDisco novaVendaDisco = new VendaDisco(discoService.procurar(vendaDisco.getDisco()));
            novaVendaDisco.setValorCashback(carregaCashback(novaVendaDisco.getDisco(), venda.getRegistroDaVenda()));
        }
        return auxiliar;
    }

    private BigDecimal carregaCashback(Disco disco, Date data) {
        Cashback cashback = cashbackRepository.buscarPorGenero(disco.getGeneroMusical(), new DatasUtil().pegaDiaDaSemana(data));
        return disco.getPreco().multiply(new BigDecimal(cashback.getPorcentagem() / 100));

    }
}
