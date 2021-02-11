package ru.job4j.parserNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParserNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParserNewsApplication.class, args);
	}

}
