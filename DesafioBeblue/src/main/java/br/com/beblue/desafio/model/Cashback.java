package br.com.beblue.desafio.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author henri
 */
@Entity
public class Cashback {

    @EmbeddedId
    private CashbackPK id;
    private Integer porcentagem;

    public CashbackPK getId() {
        return id;
    }

    public void setId(CashbackPK id) {
        this.id = id;
    }

    public Integer getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Integer porcentagem) {
        this.porcentagem = porcentagem;
    }

    
    
}
