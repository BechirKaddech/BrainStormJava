/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class MailController implements Initializable {

    @FXML
    private TextField us;
    @FXML
    private TextField mo;
    @FXML
    private TextField fr;
    @FXML
    private TextField t;
    @FXML
    private TextField su;
    @FXML
    private TextField te;
//    @FXML
//    private TextField fi;    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         
        
      
 
        t.setText("moez.saidi@esprit.tn");

    }    

    @FXML
    private void send(ActionEvent event) throws MessagingException, IOException {
       final String username = us.getText();
		final String password = mo.getText();

		
/* L'adresse de l'expéditeur */
String from = fr.getText();

/* L'adresse du destinataire */
 String to =t.getText();

/* L'objet du message */
String objet = su.getText();

/* Le corps du mail */
String texte = te.getText();
String pieceJointe = null;
Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		  });
            

///* Création du message*/
Message msg = new MimeMessage(session);

try {
      msg.setFrom(new InternetAddress(from));
      msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to, false));
      msg.setSubject(objet);
      msg.setText(texte);
      msg.setHeader("X-Mailer", "LOTONtechEmail");
      
       // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText("");
         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = "C:\\Users\\dell\\Desktop\\GOVOYAGE-JAVA\\fadwati.pdf";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         msg.setContent(multipart);
      Transport.send(msg);
}
catch (AddressException e) {
      e.printStackTrace();
} 
catch (MessagingException e) {
      e.printStackTrace();
}
 }  
    
}
