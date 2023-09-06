package com.reference.genai.sandbox;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Slf4j
	@RestController
	public class SampleController {

		@Value("${message:hey}")
		private String message;

		@GetMapping
		public ResponseEntity<String> sayHello() {
			log.info("Processing request; message: {}", message);
			return ResponseEntity.ok(message);
		}

	}
}
