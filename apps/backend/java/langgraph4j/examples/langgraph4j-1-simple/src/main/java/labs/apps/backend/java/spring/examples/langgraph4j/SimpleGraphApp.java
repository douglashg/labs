package labs.apps.backend.java.spring.examples.langgraph4j;

import static org.bsc.langgraph4j.GraphDefinition.END;
import static org.bsc.langgraph4j.GraphDefinition.START;
import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;

import java.util.Map;

import org.bsc.langgraph4j.GraphStateException;
import org.bsc.langgraph4j.StateGraph;

//import dev.langchain4j.model.openai.OpenAiChatModel;

public class SimpleGraphApp {

  public static void main(String[] args) throws GraphStateException {

    /**
    var model = OpenAiChatModel.builder()
        .ollamaApi(OllamaApi.builder()
        .baseUrl("http://localhost:11434").build())
        .defaultOptions(OllamaOptions.builder().model("qwen2.5:7b").temperature(0.1).build())
        .build();

    var agent = AgentExecutor.builder().chatModel(model).toolsFromObject(new TestTool()).build().compile();

    for (var item : agent.stream(Map.of("messages", "perform test twice and return number of current active threads"))) {
      System.out.println(item);
    }
    */
    
    // Initialize nodes
    GreeterNode greeterNode = new GreeterNode();
    ResponderNode responderNode = new ResponderNode();

    // Define the graph structure
    var stateGraph = new StateGraph<>(SimpleState.SCHEMA, initData -> new SimpleState(initData))
        .addNode("greeter", node_async(greeterNode)).addNode("responder", node_async(responderNode))
        // Define edges
        .addEdge(START, "greeter") // Start with the greeter node
        .addEdge("greeter", "responder").addEdge("responder", END) // End after the responder node
    ;
    // Compile the graph
    var compiledGraph = stateGraph.compile();

    // Run the graph
    // The `stream` method returns an AsyncGenerator.
    // For simplicity, we'll collect results. In a real app, you might process them
    // as they arrive.
    // Here, the final state after execution is the item of interest.

    for (var item : compiledGraph.stream(Map.of(SimpleState.MESSAGES_KEY, "Let's, begin!"))) {

      System.out.println(item);
    }

  }
}