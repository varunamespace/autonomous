package com.slack.autonomous;

import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ListToolsResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * MCP client wrapper around the local Python RAG MCP server.
 * The McpSyncClient beans are auto-configured by spring-ai-starter-mcp-client
 * from the mcp client settings in application.properties / mcp-servers config.
 */
@Service
public class RagMcpServer {

    private final McpSyncClient mcpClient;

    public RagMcpServer(List<McpSyncClient> mcpClients) {
        if (mcpClients.isEmpty()) {
            throw new IllegalStateException("No MCP clients configured. Check your MCP client configuration.");
        }
        this.mcpClient = mcpClients.get(0);
    }

    /** List the tools exposed by the Python RAG MCP server. */
    public ListToolsResult listTools() {
        return mcpClient.listTools();
    }

    /** Call a named tool on the Python RAG MCP server with the given arguments. */
    public CallToolResult callTool(String toolName, Map<String, Object> arguments) {
        return mcpClient.callTool(new CallToolRequest(toolName, arguments));
    }
}
