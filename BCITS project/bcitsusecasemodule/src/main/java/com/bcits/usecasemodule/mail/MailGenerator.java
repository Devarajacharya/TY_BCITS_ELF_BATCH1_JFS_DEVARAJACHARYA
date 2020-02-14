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

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;

public class MailGenerator {

	public void sendMail(CurrentBill currentBill, ConsumerInfoBean consumerInfoBean) {

		System.out.println("Sending Mail...");

		final String username = "deju0095@gmail.com";
		final String password = "XXXXXXXX";

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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(consumerInfoBean.getEmail()));
			message.setSubject("DESCOM Online Service");
			message.setText("Dear Consumer," 
					+ "\n\n RR Number   : "+consumerInfoBean.getRrNumber()
					+ "\n\n Statmented Date :" + date
					+ "\n\n\n Personal Details "
					+ "\n\n Name     : "+consumerInfoBean.getFirstName()+" "+consumerInfoBean.getLastName()
					+ "\n Address  : "+consumerInfoBean.getHouseNumber()+" "+consumerInfoBean.getAddress1()
					+ "\n\n\n Bill Details "
					+ "\n Pres.Rdg        : "+currentBill.getPresenceReading()
					+ "\n Prev.Rdg        : "+currentBill.getPreviousReading()
					+ "\n Consumption(Units):" + currentBill.getConsumption()
					+ "\n Bill Amt        :" + currentBill.getBillAmount()
					+ "\n Due Date        :" + dueDate
					+ "\n Happy To Help");

			Transport.send(message);

			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}