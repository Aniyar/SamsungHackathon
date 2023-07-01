package com.hackathon.sic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SamsungHackApplication {
	@Value("${NAME:SamsungHackathon}")
	String name;

	public static void main(String[] args) {
		SpringApplication.run(SamsungHackApplication.class, args);
	}

}
