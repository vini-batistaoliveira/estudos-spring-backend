package com.vinicius.demo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.demo.services.DBService;

//indica que esse arquivo é arquivo de configuração para 
//o profile de dev application-dev.properties

@Configuration
@Profile("dev") 
public class DevConfig {

	@Autowired
	private DBService dbservice;
	
	//Pega o valor da chave no application-dev.properties
	// e verifica qual a estratégia para criação do banco de dados
	// se estiver create na chave, será criado toda vez que for iniciada o app
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		} else {
		
		//Instancia BD de dev, DBService
		dbservice.instantiateTestDatabase();
		return true;
		
		}
	}
	
	
}
