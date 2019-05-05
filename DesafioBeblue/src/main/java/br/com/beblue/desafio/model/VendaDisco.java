package br.com.beblue.desafio.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private Disco disco;
    private BigDecimal valorPago;
    private BigDecimal valorCashback;

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

}
