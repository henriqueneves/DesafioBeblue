package br.com.beblue.desafio.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author henri
 */

@Entity
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
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
    
    private void calculaCashbackTotal(){
        BigDecimal cashbackTotal = new BigDecimal(0);
        this.vendaDiscos.forEach(
            n -> cashbackTotal.add(n.getValorCashback())
        );
        this.cashbackTotal = cashbackTotal;
    }
    
    private void calculaValorTotal(){
        BigDecimal valorTotal = new BigDecimal(0);
        this.vendaDiscos.forEach(
            n -> valorTotal.add(n.getValorPago())
        );
    }
    
    public void calcularValores(){
        calculaCashbackTotal();
        calculaValorTotal();
    }
    
}
