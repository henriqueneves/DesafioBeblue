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
    
    public CashbackPK(){
        
    }

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
    
     @Override
    public boolean equals(Object obj) {
        if(obj instanceof CashbackPK){
            CashbackPK cashbackPK = (CashbackPK) obj;
            if(cashbackPK.getDiaDaSemana().getValue() != diaDaSemana.getValue()){
                return false;
            }
            if(!cashbackPK.getGeneroMusical().getNome().equals(generoMusical.getNome())){
                return false;
            }
            return true;
        }
        return false;
    }

    
    @Override
    public int hashCode() {
        return generoMusical.getNome().hashCode() + diaDaSemana.getValue();
    }

    
    
    
}
