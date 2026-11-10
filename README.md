# Sistema de Biblioteca - Prática 06 (GoF - Decorator)

Este repositório contém a evolução do sistema de gerenciamento de biblioteca em Java. 

**Objetivo desta prática:** 
Implementar o padrão estrutural **Decorator** (Gang of Four) sobre o módulo de notificações (`ServicoNotificacao`), permitindo acoplar novos canais e comportamentos dinamicamente em tempo de execução (SMS, WhatsApp, Auditoria com timestamp) sem alterar as classes de alto nível (`Usuario`, `Emprestimo`) e preservando os princípios SOLID (DIP e OCP).

## Padrão Decorator Aplicado
* **Component:** `ServicoNotificacao`
* **Concrete Components:** `NotificacaoConsole`, `NotificacaoEmail`
* **Base Decorator:** `NotificacaoDecorator`
* **Concrete Decorators:**
  * `NotificacaoSMSDecorator` (envio por SMS)
  * `NotificacaoWhatsAppDecorator` (envio por WhatsApp)
  * `NotificacaoLogDecorator` (auditoria com horário da operação)
