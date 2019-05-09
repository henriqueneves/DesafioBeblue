package br.com.beblue.desafio.util.filters;

import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 *
 * @author henri
 */
@Component
public class FiltroDisco extends FiltroPageRequest {

    @NotEmpty(message = "{field.required}")
    private String generoMusical;

    @Override
    public String getOrdenarPor() {
        return (super.getOrdenarPor() == null ? "nome" : super.getOrdenarPor());
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical.toUpperCase();
    }

}
