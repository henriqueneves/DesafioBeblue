package br.com.beblue.desafio.model;

import java.math.BigDecimal;
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
    private List<VendaDisco> discos = new ArrayList();
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

    public List<VendaDisco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<VendaDisco> discos) {
        this.discos = discos;
    }
    
}
