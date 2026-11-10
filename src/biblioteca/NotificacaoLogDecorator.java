package biblioteca;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class NotificacaoLogDecorator extends NotificacaoDecorator {
    public NotificacaoLogDecorator(ServicoNotificacao wrappee) {
        super(wrappee);
    }

    @Override
    public void notificar(String mensagem) {
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[LOG AUDITORIA " + hora + "] Disparando eventos de notificação...");
        super.notificar(mensagem);
    }
}
