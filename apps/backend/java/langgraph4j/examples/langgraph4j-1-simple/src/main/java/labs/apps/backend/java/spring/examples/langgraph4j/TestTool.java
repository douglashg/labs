package labs.apps.backend.java.spring.examples.langgraph4j;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

public class TestTool {

  @Tool("tool for test AI agent executor")
  String execTest(@P("test message") String message) { // If Spring AI: @ToolParam(description ="test message")
    return String.format("test tool ('%s') executed with result 'OK'", message);
  }

  @Tool("return current number of system thread allocated by application")
  int threadCount() {
    return Thread.getAllStackTraces().size();
  }

}