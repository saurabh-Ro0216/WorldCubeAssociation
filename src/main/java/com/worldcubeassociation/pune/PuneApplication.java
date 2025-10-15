package com.worldcubeassociation.pune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PuneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuneApplication.class, args);
		System.out.println("\n===========================================");
		System.out.println("🚀 Pune Competitions API is running!");
		System.out.println("📍 URL: http://localhost:8080/api/competitions/pune");
		System.out.println("===========================================\n");
	}

}
