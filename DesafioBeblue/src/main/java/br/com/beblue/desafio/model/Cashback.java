/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.model;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
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
