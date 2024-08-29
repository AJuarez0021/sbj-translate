package com.work.traductor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SfbTraductorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfbTraductorApplication.class, args);
	}

}
