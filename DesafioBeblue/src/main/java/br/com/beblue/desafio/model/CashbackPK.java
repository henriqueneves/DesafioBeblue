/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.model;

import java.io.Serializable;
import java.time.DayOfWeek;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author henri
 */
@Embeddable
public class CashbackPK implements Serializable {
    
    @ManyToOne
    private GeneroMusical generoMusical;
    private DayOfWeek diaDaSemana;

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    public DayOfWeek getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DayOfWeek diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }
    
    
    
}
