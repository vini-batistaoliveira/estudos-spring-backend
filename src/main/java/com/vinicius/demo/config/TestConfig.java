package com.vinicius.demo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.demo.services.DBService;

//indica que esse arquivo é arquivo de configuração para 
//o profile de test application-test.properties

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
	
	
}
