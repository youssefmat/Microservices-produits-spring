package com.formation.mvc.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHANUMERIQUE= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String genereteStringId(int length) {
		
		StringBuilder returnValue = new StringBuilder();
		
		for(int i =0 ; i<length ;i++) {
			
			returnValue.append(ALPHANUMERIQUE.charAt(RANDOM.nextInt(ALPHANUMERIQUE.length())));
		}
		
		return new String(returnValue);
		
	}
}
