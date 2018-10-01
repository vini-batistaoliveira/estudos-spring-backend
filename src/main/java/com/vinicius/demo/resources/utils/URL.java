package com.vinicius.demo.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	//Metodo utilitario para pegar os valores de categoria que vem na url 
	//vem como string e converter em uma List<Integer>
	
	public static List<Integer> decodeIntList(String s){
		
		String[] vet = s.split(",");
		List<Integer> list = new ArrayList<>();
		for(int i=0; i < vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		return list;
	}
	
	//Decodificar os parametros de retorno de uma url
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	
}
