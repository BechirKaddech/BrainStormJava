/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.AbonneDao;
import com.govoyage.DAO.CompteDao;
import com.govoyage.ENTITIES.Abonne;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AffichageCompteController implements Initializable {

    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Label nomlabel;
    @FXML
    private Label prenomlabel;
    @FXML
    private Label emaillabel;
    @FXML
    private Label usernamelabel;
    @FXML
     private ListView<String> listview;
    
    @FXML
    private Label nom;
    
    @FXML
    private Label prenom;
        
    @FXML
    private Label email;
    
    @FXML
    private Label username;    
            
            
    
    List<Abonne> liste = new ArrayList<>();
    
    

   @FXML
     private void DeleteAction(ActionEvent event) {
         CompteDao compte = new CompteDao();
         compte.supprimerCompte(LoginController.user.getId());
         
     }
     
      @FXML
    private void ModifierAction(ActionEvent event) throws IOException 
    {
     ((Node) event.getSource()).getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Modifiercompte.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nom.setText(LoginController.user.getNom());
        prenom.setText(LoginController.user.getPrenom());
        email.setText(LoginController.user.getEmail());
        username.setText(LoginController.user.getUsername());
        
    }    

    @FXML
     private void btnDownloadAction(ActionEvent event)
     {
         Document document = new Document();
         AbonneDao dao = new AbonneDao();
         List<Abonne> list = new ArrayList<>();
         list = dao.AfficherAbonne(LoginController.user.getId());
         
        try {
            PdfWriter.getInstance(document, new FileOutputStream("fadwati.pdf"));
            document.open();

            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            Font fontbold = FontFactory.getFont("Times-Roman", 18, Font.BOLD);
            Chunk chunk0 = new Chunk("Mes Coordonnées\n\n\n");
            chunk0.setFont(fontbold);
            paragraph.add(chunk0);
            for (int i = 0; i<1; i++) {
                Chunk chunk1 = new Chunk("Nom: "+LoginController.user.getNom()+"\n");
                Chunk chunk2 = new Chunk("Prenom: "+LoginController.user.getPrenom()+"\n");
                Chunk chunk3 = new Chunk("Email: "+LoginController.user.getEmail()+"\n");
                Chunk chunk4 = new Chunk("User Name: "+LoginController.user.getUsername()+"\n");
  
                paragraph.add(chunk1);
                paragraph.add(chunk2);
                paragraph.add(chunk3);
                paragraph.add(chunk4);
            }
   
            document.add(paragraph);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
     }
     
      @FXML
    public void Home(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
