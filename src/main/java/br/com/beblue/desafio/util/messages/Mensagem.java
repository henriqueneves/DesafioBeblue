package br.com.beblue.desafio.util.messages;

/**
 *
 * @author henri
 */
public abstract class  Mensagem {
    
    private String mensagem;

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public abstract String getTipo();
    
}
