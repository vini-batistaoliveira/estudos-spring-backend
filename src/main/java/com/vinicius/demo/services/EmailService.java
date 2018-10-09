package com.vinicius.demo.services;

import org.springframework.mail.SimpleMailMessage;

import com.vinicius.demo.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
