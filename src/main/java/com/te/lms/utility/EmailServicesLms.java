package com.te.lms.utility;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServicesLms {

	@Autowired
	JavaMailSender mailSender;
	

	public String sendPassword(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ajay.k@testyantra.com");
		message.setTo(to);
		message.setSubject("Auto Generated Password");
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		message.setText("The password ==> "+uuid);
		this.mailSender.send(message);
		return ""+uuid;				
	}
}
