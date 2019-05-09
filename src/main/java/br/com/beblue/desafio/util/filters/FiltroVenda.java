package br.com.beblue.desafio.util.filters;

import br.com.beblue.desafio.util.DatasUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author henri
 */
@Component
public class FiltroVenda extends FiltroPageRequest {

    @NotNull(message = "{field.required}")
    private Date dataInicial;
    @NotNull(message = "{field.required}")
    private Date dataFinal;

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = new DatasUtil().stringToDate(dataInicial);
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = new DatasUtil().stringToDate(dataFinal);
    }


    @Override
    public String getOrdenarPor() {
        return (super.getOrdenarPor() == null ? "registroDaVenda" : super.getOrdenarPor());
    }

}
