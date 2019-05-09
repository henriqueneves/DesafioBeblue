package br.com.beblue.desafio.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author henri
 */
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    @NotNull(message = "{field.required}")
    private List<VendaDisco> vendaDiscos = new ArrayList();
    private BigDecimal valorTotal;
    private BigDecimal cashbackTotal;
    private Date registroDaVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getCashbackTotal() {
        return cashbackTotal;
    }

    public void setCashbackTotal(BigDecimal cashbackTotal) {
        this.cashbackTotal = cashbackTotal;
    }

    public Date getRegistroDaVenda() {
        return registroDaVenda;
    }

    public void setRegistroDaVenda(Date registroDaVenda) {
        this.registroDaVenda = registroDaVenda;
    }

    public List<VendaDisco> getVendaDiscos() {
        return vendaDiscos;
    }

    public void setVendaDiscos(List<VendaDisco> vendaDiscos) {
        this.vendaDiscos = vendaDiscos;
    }

    private void calculaCashbackTotal() {
        this.cashbackTotal = this.vendaDiscos.stream().map(
                n -> n.getValorCashback()
        ).reduce(BigDecimal::add).get();
    }

    private void calculaValorTotal() {
        this.valorTotal = this.vendaDiscos.stream().map(
                n -> n.getValorPago()
        ).reduce(BigDecimal::add).get();
    }

    public void calcularValores() {
        calculaCashbackTotal();
        calculaValorTotal();
    }
    
    public void setVendaDiscoReferencia(){
        this.vendaDiscos.forEach( n -> n.setVenda(this));
    }

}
