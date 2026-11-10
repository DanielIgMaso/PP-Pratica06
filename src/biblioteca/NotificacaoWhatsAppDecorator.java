package biblioteca;

public class NotificacaoWhatsAppDecorator extends NotificacaoDecorator {
    public NotificacaoWhatsAppDecorator(ServicoNotificacao wrappee) {
        super(wrappee);
    }

    @Override
    public void notificar(String mensagem) {
        super.notificar(mensagem);
        enviarWhatsApp(mensagem);
    }

    private void enviarWhatsApp(String mensagem) {
        System.out.println("[WHATSAPP] " + mensagem);
    }
}
