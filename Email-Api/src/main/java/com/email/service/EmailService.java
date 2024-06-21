package com.email.service;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.websocket.Session;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	
	public void sendEmail(String to , String subject, String message) {
		
		String host="smtp.gmail.com";
		
		
		Properties prop=System.getProperties();
		System.out.println("PROPERTIES"+prop);
	
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.host", 465);
		
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.auth", "true");
		
		
		
		Session session=Session.getInstance(prop,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("tech.akash9649@gmail.com", "*******");
			}
		});
		
		session.setDebug(true);
		
	
	}
	
}
