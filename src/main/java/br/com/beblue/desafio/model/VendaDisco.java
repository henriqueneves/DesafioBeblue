package br.com.beblue.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author henri
 */
@Entity
public class VendaDisco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(updatable = false)
    @NotEmpty(message = "{field.required}")
    private Disco disco;
    private BigDecimal valorPago;
    private BigDecimal valorCashback;
    @ManyToOne
    @JsonIgnore
    private Venda venda;
    
    public VendaDisco(){
        
    }
    
    public VendaDisco(Disco disco){
        this.disco = disco;
        this.valorPago = disco.getPreco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorCashback() {
        return valorCashback;
    }

    public void setValorCashback(BigDecimal valorCashback) {
        this.valorCashback = valorCashback;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

}
