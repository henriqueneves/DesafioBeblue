package br.com.beblue.desafio.util.Messages;

/**
 *
 * @author henri
 */
public class MensagemError extends Mensagem {

    public MensagemError(String mensagem) {
        super(mensagem);
    }

    @Override
    public String getTipo() {
        return "danger";
    }

    public static MensagemError erroGenericoExcessao() {
        return new MensagemError("Erro inesperado. Por favor, tente novamente ou entre em contato com os administradores do sistema.");
    }

    public static MensagemError resultHasErros() {
        return new MensagemError("Campo(s) com valor(es) inválido(s). Por favor, verifique e tente novamente.");
    }
}
