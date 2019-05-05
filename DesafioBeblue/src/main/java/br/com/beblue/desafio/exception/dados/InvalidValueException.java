/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.exception.dados;

import br.com.beblue.desafio.exception.SystemRuntimeException;

/**
 *
 * @author henri
 */
public class InvalidValueException extends SystemRuntimeException {

    public InvalidValueException() {
    }

    public InvalidValueException(String message) {
        super(message);
    }

}
