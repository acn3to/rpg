package com.skyrim.rpg.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "RPG API", version = "1", description = "A Skyrim turn based RPG API"))
@ComponentScan(basePackages = {"com.skyrim.rpg"})
public class RpgApplication {
	public static void main(String[] args) {
		SpringApplication.run(RpgApplication.class, args);
	}
}
