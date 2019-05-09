package br.com.beblue.desafio.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henri
 */
public class DatasUtil {

    public DayOfWeek pegaDiaDaSemana(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return DayOfWeek.of(c.get(Calendar.DAY_OF_WEEK));
    }
    
    //Formato: yyyy-MM-dd
    public Date stringToDate(String s){
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            return formato.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

}
