package com.waldomilanes.invoice.utilities;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component	
public class SmtpMailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void send(String to, String subject, String body){
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
		
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body);
//			helper.addAttachment(arg0, arg1);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
