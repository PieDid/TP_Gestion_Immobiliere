package com.intiformation.gestionimmo.security.tool;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encodage {

	public static String crypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String cryptpassword = passwordEncoder.encode(password);
		return cryptpassword;
	}
}
