/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beblue.desafio.util.messages;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 *
 * @author henri
 */
@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource);
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }

    public String get(MessageSourceResolvable msr) {
        return accessor.getMessage(msr);
    }

    public List<String> get(BindingResult result) {
        List<String> erros = new ArrayList();

        result.getAllErrors().forEach(
                erro -> erros.add(get(erro))
        );

        return erros;
    }

}
