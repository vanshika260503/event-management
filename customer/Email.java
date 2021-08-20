package customer;


	import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.AddressException;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeBodyPart;
	import javax.mail.internet.MimeMessage;
	import javax.mail.internet.MimeMultipart;

import login.CustomerLogin;
import login.CustomerRegister;
import login.DBConnection;
import main.Welcome;


	public class Email
	{

		//SETUP MAIL SERVER PROPERTIES
		//DRAFT AN EMAIL
		//SEND EMAIL
		public static String getEmail;	
		Session newSession = null;
		MimeMessage mimeMessage = null;


		void sendEmail() throws MessagingException {
			String fromUser = "abc@gmail.com";  //Enter sender email id
			String fromUserPassword = "";  //Enter sender gmail password , this will be authenticated by gmail smtp server
			String emailHost = "smtp.gmail.com";
			Transport transport = newSession.getTransport("smtp");
			transport.connect(emailHost, fromUser, fromUserPassword);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			System.out.println("\n--------------------------");
			System.out.println("Email successfully sent!!!");
			System.out.println("Thank you for booking!\n Have a awesome event!");
			System.out.println("----------------------------");
		}

		MimeMessage draftEmail() throws AddressException, MessagingException, IOException, ClassNotFoundException, SQLException {
			if(Welcome.choice2.equals("1")) {
	      		 getEmail = CustomerLogin.getEmail();
	    	   }
	    	   else {
	      		 getEmail = CustomerRegister.getEmail();
	    	   }
			String[] emailReceipients = {getEmail};  //Enter list of email recepients
			String emailSubject = "Booking confirmed!!";
			String emailBody = "Test Body of my email";
			mimeMessage = new MimeMessage(newSession);
			
			for (int i =0 ;i<emailReceipients.length;i++)
			{
				mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
			}
			mimeMessage.setSubject(emailSubject);
		    
			 MimeBodyPart bodyPart = new MimeBodyPart();
			 bodyPart.setContent(emailBody,"html/text;charset=utf-8");

	    	   Connection conn = DBConnection.connect();
	    	   Statement st = conn.createStatement();
	   			int venueId = 0;
	   			String bookVenue = null;
	   			int catering = 0;
	   			String bookCatering = null;
	   			int music = 0;
	   			String bookMusic = null;
	   			int photography = 0;
	   			String bookPhotographer = null ;
	   			int decoration = 0;
	   			String bookDecorator = null ;
	   			double price =0;
	   			ResultSet rs17 = st.executeQuery("SELECT * FROM booking");
	   			while(rs17.next()) {
	   				int id = rs17.getInt("bookingID");
	   				if(id == Payment.getBookingID()) {
	   					venueId = rs17.getInt("venue");
	   					catering = rs17.getInt("catering");
	   					music = rs17.getInt("music");
	   					photography = rs17.getInt("photography");
	   					decoration = rs17.getInt("decoration");
	   					price = rs17.getDouble("price");
	   				}
	   			}
	   			
	   			ResultSet rs1 = st.executeQuery("SELECT * FROM venue");
	   	   		while(rs1.next()) {
	   	   			String venue = rs1.getString("name");
	   	   			int id = rs1.getInt("id");
	   	   			if(id == venueId) {
	   	   				bookVenue = venue;
	   	   			}
	   	   		}
	   	   		ResultSet rs2 = st.executeQuery("SELECT * FROM catering");
	   	   		while(rs2.next()) {
	   	   			String name = rs2.getString("name");
	   	   			int id = rs2.getInt("id");
	   	   			if(id == catering) {
	   	   				bookCatering = name;
	   	   			}
	   	   		}
	   	   		ResultSet rs3 = st.executeQuery("SELECT * FROM decorator");
	   	   		while(rs3.next()) {
	   	   			String name = rs3.getString("name");
	   	   			int id = rs3.getInt("id");
	   	   			if(id == decoration) {
	   	   				bookDecorator = name;
	   	   			}
	   	   		}
	   	   		ResultSet rs4 = st.executeQuery("SELECT * FROM music");
	   	   		while(rs4.next()) {
	   	   			String name = rs4.getString("name");
	   	   			int id = rs4.getInt("id");
	   	   			if(id == music) {
	   	   				bookMusic = name;
	   	   			}
	   	   		}
	   	   		ResultSet rs5 = st.executeQuery("SELECT * FROM photographer");
	   	   		while(rs5.next()) {
	   	   			String name = rs5.getString("name");
	   	   			int id = rs5.getInt("id");
	   	   			if(id == photography) {
	   	   				bookPhotographer = name;
	   	   			}
	   	   		}
	   	   	bodyPart.setText("Hey there !"
			 		+ "\nYour event is booked sucsessfully! "+
	   	   			"\n" +
					 "\nYour booking details are :" + 
			 		"\nVenue : " + bookVenue + 
			 		"\nCatering : " + bookCatering + 
			 		"\nPhotographer : " + bookPhotographer +
			 		"\nMusic System : " + bookMusic + 
			 		"\nDecorator : " + bookDecorator +
			 		"\nPrice : " + price +
			 		"\n"+
			 		"\nTHANK YOU FOR BOOKING EVENT WITH US!!");
	   	   		
			 MimeMultipart multiPart = new MimeMultipart();
			 multiPart.addBodyPart(bodyPart);
			 mimeMessage.setContent(multiPart);
			 return mimeMessage;
		}

		void setupServerProperties() {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			newSession = Session.getDefaultInstance(properties,null);
		}
		
	}

