package br.com.beblue.desafio.dto;

import br.com.beblue.desafio.util.messages.Mensagem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henri
 */
public class ResponseDTO {
    
     private Object data;
    private Mensagem mensagem;
    private List<String> erros = new ArrayList();

    public ResponseDTO() {
    }

    public ResponseDTO(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public List<String> getErros() {
        return erros;
    }

    public ResponseDTO comData(Object data) {
        this.data = data;

        return this;
    }

    public ResponseDTO comMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;

        return this;
    }

    public ResponseDTO comErros(List<String> erros) {
        this.erros.addAll(erros);

        return this;
    }
    
}
