package com.nlw.esports.server;

import com.nlw.esports.server.models.Game;
import com.nlw.esports.server.repositories.GameRepository;
import com.nlw.esports.server.services.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
