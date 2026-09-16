# Fluxo de Trabalho Base com LangGraph4j

Este projeto demonstra a criação e execução de um fluxo de trabalho de agentes utilizando o framework [LangGraph4j](https://github.com/langgraph4j/langgraph4j "LangGraph for Java is a library for Graph ... - GitHub"). O exemplo ilustra como estruturar e gerenciar o estado da aplicação através de canais acumulativos, definir nós de execução, conectar arestas, compilar e realizar o *stream* de dados em Java.

## 🚀 Estrutura do Fluxo

O fluxo de execução segue um caminho linear simples entre os nós, gerenciando o ciclo de vida das mensagens:

---

### Componentes de Estado e Nós

*   **SimpleState (`MESSAGE_KEY`)**: Define o estado compartilhado do grafo. Utiliza um `AppenderChannel` (canal do tipo append), o que garante que novos elementos sejam acumulados em uma lista ao invés de sobrescrever os dados anteriores.
*   **GreeterNode**: O nó inicial do fluxo de trabalho. Adiciona a mensagem `"Olá"` (ou *"Hello"*) ao canal de mensagens.
*   **ResponderNode**: O nó subsequente. Realiza a leitura e a verificação da saudação inserida no estado e, em seguida, adiciona uma confirmação (acknowledgment) correspondente.

---

## 🛠️ Ciclo de Desenvolvimento no LangGraph4j

A arquitetura do agente segue 5 passos essenciais para execução de fluxos baseados em grafos:

1.  **Definição do Estado**: Configuração do `SimpleState` mapeando chaves com seus respectivos redutores (`AppenderChannel`).
2.  **Definição dos Nós**: Registro dos componentes funcionais e suas lógicas de negócio (`GreeterNode` e `ResponderNode`).
3.  **Mapeamento de Arestas (Edges)**: Definição programática do roteamento de transições: `START` ──> `greeter` ──> `responder` ──> `END`.
4.  **Compilação do Grafo**: Invocação do método `stateGraph.compile()`, que valida a integridade lógica e retorna um executável `CompiledGraph`.
5.  **Execução do Stream**: Processamento por meio de `compiledGraph.stream(initialState)`.

---

## 💻 Exemplo de Implementação (Java)

Ao iterar pelo fluxo gerado pela execução do grafo, cada item do loop representa o estado modificado imediatamente após a saída de um nó específico:

```java
// Inicialização e execução por streaming do grafo compilado
for (var item : compiledGraph.stream(initialState)) {
    System.out.println(item);
}
```

*Nota: O comportamento reativo do método `stream` do [LangGraph4j](https://github.com/langgraph4j/langgraph4j "LangGraph for Java is a library for Graph ... - GitHub") retorna geradores assíncronos capazes de rastrear deltas de estado passo a passo, ideal para registrar logs, depurar ou enviar atualizações em tempo real para a interface.*