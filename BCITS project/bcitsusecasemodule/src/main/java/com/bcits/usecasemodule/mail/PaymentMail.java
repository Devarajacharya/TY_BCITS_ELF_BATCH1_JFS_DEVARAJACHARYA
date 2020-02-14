package com.bcits.usecasemodule.mail;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;

public class PaymentMail {

	public void successfullPaymentMail(double amount, ConsumerInfoBean consumerInfoBean) {

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

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy hh-mm-ss");
		String date = dateFormat.format(new Date());

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(consumerInfoBean.getEmail()));
			message.setSubject("Payment Successful");
			message.setText("Dear Consumer," 
					+ "\n\n Transaction Successful. Your Transaction Details are given below : "
					+"\n\n Transaction Id   : 55e977e57d487"
					+"\n Transaction Amount: "+amount
					+"\n Transaction Status: Success "
					+ "\n Payment Date       :" + date
					+"\n\n\n Click here to vist : www.discomOnlineService.com"
					+ "\n Happy To Help");

			Transport.send(message);

			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
