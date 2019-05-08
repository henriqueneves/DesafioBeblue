package br.com.beblue.desafio.util;

import br.com.beblue.desafio.util.Messages.MensagemSuccess;
import br.com.beblue.desafio.util.Messages.MensagemError;
import br.com.beblue.desafio.dto.ResponseDTO;
import br.com.beblue.desafio.exception.SystemRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author henri
 */
public class TryCatchDefaultRest {
    
    private Object data;
    private String successMessage;

    public TryCatchDefaultRest(Object data, String successMessage) {
        this.data = data;
        this.successMessage = successMessage;
    }

    public ResponseEntity<ResponseDTO> execute(Runnable funcao) {
        try {
            funcao.run();

            return ResponseEntity.ok().body(
                    new ResponseDTO(data)
                            .comMensagem(new MensagemSuccess(successMessage))
            );
        } catch (SystemRuntimeException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseDTO(data)
                            .comMensagem(new MensagemError(e.getMessage()))
            );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDTO(data)
                            .comMensagem(MensagemError.erroGenericoExcessao())
            );
        }
    }

    public void setData(Object data) {
        this.data = data;
    }
    
}
