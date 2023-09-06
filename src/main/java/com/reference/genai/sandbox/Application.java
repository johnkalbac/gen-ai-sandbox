package com.reference.genai.sandbox;

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

	@RestController
	public class SampleController {

		@Value("${message:hey}")
		private String message;

		@GetMapping
		public ResponseEntity<String> sayHello() {
			return ResponseEntity.ok(message);
		}

	}
}
