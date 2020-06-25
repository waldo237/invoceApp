package com.waldomilanes.invoice.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waldomilanes.invoice.utilities.SmtpMailSender;

@RestController
public class MailController {

	@Autowired
	private SmtpMailSender smptpMailSender;
	
	@RequestMapping("/sendmail")
	public void sendMail(){
		smptpMailSender.send("waldo23792@gamil.com", "Mensaje desde spring", "Hello");
	}
}
