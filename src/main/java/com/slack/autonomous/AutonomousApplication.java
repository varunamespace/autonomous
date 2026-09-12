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

}
