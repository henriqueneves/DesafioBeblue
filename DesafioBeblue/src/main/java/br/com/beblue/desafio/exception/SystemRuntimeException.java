/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.exception;

/**
 *
 * @author henri
 */
public class SystemRuntimeException extends RuntimeException {

    public SystemRuntimeException() {
    }

    public SystemRuntimeException(String message) {
        super(message);
    }

}
