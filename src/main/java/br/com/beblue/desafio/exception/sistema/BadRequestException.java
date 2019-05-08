package br.com.beblue.desafio.exception.sistema;

import br.com.beblue.desafio.exception.SystemRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author henri
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends SystemRuntimeException {

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

}