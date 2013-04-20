package com.entrecine4;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

	public static void sendNewMail(String to, String fileName) {

		

		final String username = "entrecine4as@gmail.com";
		final String password = ""; // La contraseña será la que se especifiará en el fichero de Google Drive por temas de seguridad.

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		
		String from = "entrecine4as@gmail.com";
		

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("EntreCine 4 -- ENTRADA");
			message.setText("Gracias por su entrada.\n\nLe enviamos adjunto "
					+ "el código QR para que pueda imprimirlo y canjearlo por su entrada."
					+ "\n\nLe recordamos que la entrada no será activada hasta que se complete el pago."
					+ "\n\nGracias por confiar en Entrecine4.");

			// Adding the QR code attached to the mail
			FileDataSource fds = new FileDataSource(fileName);
			message.setDataHandler(new DataHandler(fds));
			message.setFileName(fds.getName());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
