package biblioteca;

public class NotificacaoSMSDecorator extends NotificacaoDecorator {
    public NotificacaoSMSDecorator(ServicoNotificacao wrappee) {
        super(wrappee);
    }

    @Override
    public void notificar(String mensagem) {
        super.notificar(mensagem);
        enviarSMS(mensagem);
    }

    private void enviarSMS(String mensagem) {
        System.out.println("[SMS] " + mensagem);
    }
}
