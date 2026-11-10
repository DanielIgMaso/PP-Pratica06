package biblioteca;

public class Principal {
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE BIBLIOTECA INICIADO (SOLID - DIP + GoF Decorator) ---\n");

        // Criando itens do acervo
        Livro livro1 = new Livro("Padrões de Projeto", "Erich Gamma");
        Revista revista1 = new Revista("Ciência Hoje", 42);
        Enciclopedia enciclopedia1 = new Enciclopedia("Barsa", 1);

        System.out.println("\nTotal de livros cadastrados: " + Livro.getTotalLivros() + "\n");

        // Criando as notificações base decoradas dinamicamente (Padrão Decorator + DIP)
        // Aluno: Notificação via Console decorada com SMS
        ServicoNotificacao notifAluno = new NotificacaoSMSDecorator(
                                            new NotificacaoConsole()
                                        );

        // Professor: Notificação via E-mail decorada com WhatsApp, SMS e Log de Auditoria
        ServicoNotificacao notifProf = new NotificacaoLogDecorator(
                                           new NotificacaoWhatsAppDecorator(
                                               new NotificacaoSMSDecorator(
                                                   new NotificacaoEmail()
                                               )
                                           )
                                       );

        // Injetando a abstração ServicoNotificacao nos usuários (Módulos de alto nível)
        Aluno aluno1 = new Aluno("João Silva", 12345, notifAluno);
        Professor prof1 = new Professor("Marco Maciel", "Computação", notifProf);

        // Polimorfismo e Inversão de Dependência (Alugando diferentes ItemEmprestavel)
        System.out.println("--- ALUGUÉIS ---");
        aluno1.alugar(livro1); // Notifica via Console
        System.out.println();

        prof1.alugar(revista1); // Aluga Revista e notifica via E-mail
        System.out.println();

        // Sobrecarga (Renovação)
        System.out.println("--- RENOVAÇÃO ---");
        aluno1.alugar(livro1, true);
        System.out.println();

        // Devolução
        System.out.println("--- DEVOLUÇÃO ---");
        prof1.devolver();
        System.out.println();

        // Testando a Interface (imprimirDados) e o Polimorfismo
        System.out.println("--- DADOS DOS OBJETOS (Interface Imprimivel) ---");
        livro1.imprimirDados();
        revista1.imprimirDados();
        enciclopedia1.imprimirDados();
        System.out.println();

        aluno1.imprimirDados();
        System.out.println();

        prof1.imprimirDados();
    }
}
