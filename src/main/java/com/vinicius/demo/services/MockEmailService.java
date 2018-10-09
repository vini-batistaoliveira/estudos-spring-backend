package com.vinicius.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

//Classe apenas para simular o envio
public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de Email");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}

}
