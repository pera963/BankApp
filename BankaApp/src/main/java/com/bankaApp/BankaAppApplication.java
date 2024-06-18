package com.bankaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="BankaAplication",version="1.0",description="Bakend Part of Aplication"))
public class BankaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankaAppApplication.class, args);
	}

}
