package Excel;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;
import java.util.*;
import java.io.*;

public class gmailA {
	public static void main(String[] args) {
		String host = "imap.gmail.com"; // Gmail IMAP server
		String username = "idrive.gs1@gmail.com"; // Your Gmail address
		String password = "idrive@123"; // Your Gmail App Password or OAuth token

		// Set up properties for connecting to Gmail IMAP
		Properties properties = new Properties();
		properties.put("mail.store.protocol", "imaps");
		properties.put("mail.imap.host", host);
		properties.put("mail.imap.port", "993");
		properties.put("mail.imap.ssl.enable", "true");

		try {
			// Connect to Gmail using the session
			Session session = Session.getDefaultInstance(properties);
			Store store = session.getStore("imaps");
			store.connect(host, username, password);

			// Open the inbox folder
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);

			// Fetch unread emails
			Message[] messages = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

			System.out.println("Number of unread messages: " + messages.length);

			// Loop through the unread messages
			for (Message message : messages) {
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Received Date: " + message.getReceivedDate());

				// Read the content of the email (text part)
				Object content = message.getContent();
				if (content instanceof String) {
					System.out.println("Text: " + content);
				}

				System.out.println("------------------------------");
			}

			// Close the folder and store
			folder.close(false);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
