package com.mballem.curso.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}
	
	@Autowired
	JavaMailSender sender;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleMailMessage simple = new SimpleMailMessage();
		simple.setTo("leonardotelles@gmail.com");
		simple.setText("Teste de envio");
		simple.setSubject("Teste de envio de e-mail");
		
		sender.send(simple);
	}
}
