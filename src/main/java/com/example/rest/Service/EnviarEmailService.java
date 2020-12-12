package com.example.rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class EnviarEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviarEmail(String from,String to, String asunto, String cuerpo) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(asunto);
		mailMessage.setText(cuerpo);
		
		javaMailSender.send(mailMessage);
	}
	
	//crea palabras aleatorias;
	public String GenerarPalabra(){
		 String palabra = ""; 
		 int caracteres = 10; 
		    for (int i=0; i<caracteres; i++){ 
		      int codigoAscii = (int)Math.floor(Math.random()*(122 -
		      97)+97); 
		      palabra = palabra + (char)codigoAscii; 
		    } 
		 return palabra; 
	} 

}
