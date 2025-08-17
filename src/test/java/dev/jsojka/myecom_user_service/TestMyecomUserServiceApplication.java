package dev.jsojka.myecom_user_service;

import org.springframework.boot.SpringApplication;

public class TestMyecomUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(MyecomUserServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
