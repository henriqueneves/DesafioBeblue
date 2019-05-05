/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.exception.sistema;

import br.com.beblue.desafio.exception.SystemRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author henri
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends SystemRuntimeException {

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException() {
    }

}
