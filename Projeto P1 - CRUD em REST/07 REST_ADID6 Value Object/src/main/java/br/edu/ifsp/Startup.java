package br.edu.ifsp;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup {
	
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
		
	}
	
	public static void addService(HttpServletResponse response, String username) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Request-Headers", "*");
	}
}
