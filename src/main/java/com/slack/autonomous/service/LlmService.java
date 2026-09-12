package com.slack.autonomous.service;

import com.slack.autonomous.RagMcpServer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LlmService {
    private final ChatClient chatClient;
    private final RagMcpServer ragMcpServer;

    public LlmService(ChatClient.Builder builder, RagMcpServer ragMcpServer) {
        this.chatClient = builder.build();
        this.ragMcpServer = ragMcpServer;
    }

    @Tool(description = "Search the public internet")
    public String webSearch(String query) {
        return "Web result for: " + query;
    }

    @Tool(description = "Search internal company documents")
    public String searchRag(String question) {
        return "RAG result for: " + ragMcpServer.callTool("search_knowledge", Map.of("query", question));
    }


    public String ask(String question) {
        return chatClient
                .prompt()
                .user(question)
                .tools(this)
                .call()
                .content();
    }
}
