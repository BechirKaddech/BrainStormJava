/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author alaa
 */
public class FeedbackSMSController implements Initializable {

    @FXML
    private TextArea smsTxt;
    @FXML
    private TextField name;
    @FXML
    private TextField num;
    @FXML
    private Button send;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
   
            
            
            
            
            
            }    

    @FXML
    private void SendSMS(ActionEvent event) {
   
    
     try 
		{
			// l'adresse email de votre compte sur www.smsfactor.com
			String username = "alaeddine.khadhraoui@esprit.tn";
			// Mot de passe de votre compte www.smsfactor.com et correspondant au login
			String password = "52222179";
			// Expéditeur du message tel qu'il apparaitra sur le téléphone.
			String sender = "FeedBack";
			// Message de votre sms
			String text = smsTxt.getText()+" Envoyer par "+name.getText()+" tel "+num.getText() ;
			// Numéro de téléphone correspondant au destinataire du message
			String gsm = "0021652222179";
			// Encodage et envoi du flux
			String contentXML ="<sms><authentification><username>"+username+"</username><password>"+password+"</password></authentification><message><sender>"+sender+"</sender><text>"+text+"</text></message><recipients><gsm>"+gsm+"</gsm></recipients></sms>";
			System.out.println("Message à envoyer : "+contentXML);
			String param = URLEncoder.encode(contentXML, "UTF-8");
			String query = String.format("XML=%s", param);
			System.out.println("Message encodé en UTF-8: "+query);
			URLConnection urlConnection = new URL("https://api.smsfactor.com").openConnection();
			urlConnection.setUseCaches(false);
			urlConnection.setDoOutput(true); // Triggers POST.
			urlConnection.setRequestProperty("accept-charset", "UTF-8");
			urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			OutputStreamWriter writer = null;
			try {
				writer = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
				writer.write(query); // Write POST query string (if any needed).
			} finally {
				if (writer != null) try { writer.close(); } catch (IOException logOrIgnore) {logOrIgnore.printStackTrace();}
			}
			
			// Récupération de la réponse
			InputStream inputStream = urlConnection.getInputStream();
			if (inputStream != null) {
	            Writer stringWriter = new StringWriter();
	 
	            char[] buffer = new char[1024];
	            try {
	                Reader reader = new BufferedReader(
	                        new InputStreamReader(inputStream, "UTF-8"));
	                int n;
	                while ((n = reader.read(buffer)) != -1) {
	                	stringWriter.write(buffer, 0, n);
	                }
	            } finally {
	            	inputStream.close();
	            }
	            System.out.println("réponse : "+stringWriter.toString());
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
