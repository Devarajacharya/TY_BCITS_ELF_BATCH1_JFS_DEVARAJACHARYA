package com.bcits.usecasemodule.mail;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bcits.usecasemodule.bean.CurrentBill;

public class MailGenerator {
	
	public void sendMail(CurrentBill currentBill ) {
		

		System.out.println("Sending Mail...");

		final String username = "deju0095@gmail.com";
		final String password = "deju9860@";
	

		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); 

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(currentBill.getDueDate());
		String date = dateFormat.format(currentBill.getStatementDate());
		
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("devrajacharya9860@gmail.com"));
			message.setSubject("Testing Gmail TLS");
			message.setText("Dear Consumer," +
			                 "\n\n This  Month you have Consumed   "+ currentBill.getConsumption()+
					         "\n\n So the total Bill will be rupees  " +currentBill.getBillAmount()+
					         "\n\n The Due Date will be "+dueDate+"\n\n"
					         		+ "\n\n"
					         		+ "Statmented On "+ date+"\n\nHappy To Help"
	                           	);
		
			Transport.send(message);

			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}