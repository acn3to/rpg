package com.skyrim.rpg.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.skyrim.rpg"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RpgApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgApplication.class, args);
	}
}
