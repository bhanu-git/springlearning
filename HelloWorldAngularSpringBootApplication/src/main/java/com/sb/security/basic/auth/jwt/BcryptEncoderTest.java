package com.sb.security.basic.auth.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i=0; i<4; i++) {
			String encoderString = encoder.encode("admin");
			System.out.println(encoderString);
		}
	}

}
