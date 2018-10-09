package com.vinicius.demo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.demo.services.DBService;
import com.vinicius.demo.services.EmailService;
import com.vinicius.demo.services.MockEmailService;

//indica que esse arquivo é arquivo de configuração para 
//o profile de test application-test.properties
//Instancia local do banco

@Configuration
@Profile("test") 
public class TestConfig {

	@Autowired
	private DBService dbservice;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		//Instancia BD de teste, DBService
		dbservice.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	
	
}
