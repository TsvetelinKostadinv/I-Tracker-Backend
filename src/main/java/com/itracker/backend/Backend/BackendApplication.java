package com.itracker.backend.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
	    System.out.println( "Starteeeed" );
		SpringApplication.run(BackendApplication.class, args);
	}
}
