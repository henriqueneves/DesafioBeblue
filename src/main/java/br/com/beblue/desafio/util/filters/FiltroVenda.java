package br.com.beblue.desafio.util.filters;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 *
 * @author henri
 */
@Component
public class FiltroVenda extends FiltroPageRequest {

    @NotEmpty(message = "{field.required}")
    private Date dataInicial;
    @NotEmpty(message = "{field.required}")
    private Date dataFinal;

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String getOrdenarPor() {
        return (super.getOrdenarPor() == null ? "registroDaVenda" : super.getOrdenarPor());
    }

}
