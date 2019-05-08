package br.com.beblue.desafio.util.Messages;

/**
 *
 * @author henri
 */
public class MensagemSuccess extends Mensagem {

    public MensagemSuccess(String mensagem) {
        super(mensagem);
    }

    @Override
    public String getTipo() {
        return "success";
    }

}
