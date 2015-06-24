package com.trucktrack.core.test.user;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;


public class TestEncryption
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		String encodedPassword = passwordEncoder.encodePassword("admin", null);
		
//		passwordEncryptor.setPlainDigest(true);
//		passwordEncryptor.setAlgorithm("SHA-1");
//		String encryptedPassword = passwordEncryptor.encryptPassword("admin");
		
		System.out.println(encodedPassword);

	}

}
