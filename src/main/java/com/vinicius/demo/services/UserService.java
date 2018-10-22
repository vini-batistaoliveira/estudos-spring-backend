package com.vinicius.demo.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.vinicius.demo.security.UserSS;

public class UserService {

	//Retorno o usuario que está logado no sistema
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		}
		catch(Exception e) {
			return null;
		}
	}
}
