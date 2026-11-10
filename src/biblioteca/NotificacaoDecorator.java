package biblioteca;

public abstract class NotificacaoDecorator implements ServicoNotificacao {
    protected ServicoNotificacao wrappee;

    public NotificacaoDecorator(ServicoNotificacao wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void notificar(String mensagem) {
        if (this.wrappee != null) {
            this.wrappee.notificar(mensagem);
        }
    }
}
