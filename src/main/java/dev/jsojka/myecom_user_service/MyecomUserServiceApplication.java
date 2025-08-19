package dev.jsojka.myecom_user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MyecomUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyecomUserServiceApplication.class, args);
	}

}
