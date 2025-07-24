package com.udemy.card;

import com.udemy.card.records.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.*;

@SpringBootApplication
@EnableConfigurationProperties(ConfigRecords.class)
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

}
