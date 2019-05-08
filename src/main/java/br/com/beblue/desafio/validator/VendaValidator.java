package br.com.beblue.desafio.validator;

import br.com.beblue.desafio.model.Venda;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author henri
 */
@Component
public class VendaValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Venda.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vendaDiscos", "field.required");
    }

}
