package br.com.beblue.desafio.util;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

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

}
