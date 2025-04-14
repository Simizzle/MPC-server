package com.simonmorgan.snacksmpcserver;

import com.simonmorgan.snacksmpcserver.service.SnacksService;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SnacksmpcserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnacksmpcserverApplication.class, args);
	}

	@Bean
	public List<ToolCallback> snacksTool(SnacksService snacksService) {
		return List.of(ToolCallbacks.from(snacksService));
	}
}
