package com.slack.autonomous;

import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class AutonomousApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutonomousApplication.class, args);
	}

//	@Bean
//	CommandLineRunner askRag(RagMcpServer rag) {
//		return args -> {
//			System.out.println("Connected tools: " + rag.listTools().tools());
//			try (Scanner scanner = new Scanner(System.in)) {
//				while (true) {
//					System.out.print("\nAsk (or 'exit'): ");
//					if (!scanner.hasNextLine()) break;
//					String question = scanner.nextLine().trim();
//					if (question.isEmpty()) continue;
//					if (question.equalsIgnoreCase("exit")) break;
//
//					CallToolResult result = rag.callTool("search_knowledge", Map.of("query", question));
//					System.out.println("Answer: " + result.content());
//				}
//			}
//		};
//	}

}
