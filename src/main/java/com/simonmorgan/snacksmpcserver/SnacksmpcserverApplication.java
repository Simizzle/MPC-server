package com.simonmorgan.snacksmpcserver;

import com.simonmorgan.snacksmpcserver.service.SnacksService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SnacksmpcserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnacksmpcserverApplication.class, args);
	}

	@Bean
	ToolCallbackProvider snacksTool(SnacksService snacksService) {
		return MethodToolCallbackProvider.builder().toolObjects(snacksService).build();
	}
}
