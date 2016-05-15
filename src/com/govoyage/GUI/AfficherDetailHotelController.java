/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.HotelDAO;
import com.govoyage.DAO.circuitvipDAO;
import com.govoyage.ENTITIES.Hotel;
import com.govoyage.ENTITIES.User;
import com.govoyage.ENTITIES.circuitvip;
import com.govoyage.UTIL.FileHandler;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import static javafx.scene.paint.Color.web;
import static javafx.scene.paint.Color.web;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fadoua
 */
public class AfficherDetailHotelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label nomHotel;
    
    @FXML
    private Label Description;    
    
    @FXML
    private Label Categorie;
    
    @FXML
    private Label Disponibilite;    
    
 
    @FXML
    private ImageView Hotelim ;
    
    @FXML
    private WebView web;
    
    
    public void initialize(URL url, ResourceBundle rb) {
        try {
            int idH = 0;
            
            if(FileHandler.fileExists("idH")){
                idH = Integer.valueOf(FileHandler.getText("idH"));
                
                Hotel h = new Hotel();
                HotelDAO crdao = new HotelDAO();
                
                h = crdao.findhotelById(idH);
                
                nomHotel.setText(h.getNomHotel());
                Description.setText(h.getDescription());
                Categorie.setText(h.getCategorie());
                Disponibilite.setText(h.getDisponibilite());
               
              
            }
             web.getEngine().load(getClass().getResource("mapo.html").toExternalForm());
            
        } catch (Exception ex) {
            Logger.getLogger(CircuitaffichedetailleController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
    
    public void tracer(ActionEvent event){
        
        int idH = 0;
        
        if(FileHandler.fileExists("idH")){
            idH = Integer.valueOf(FileHandler.getText("idH"));

            Hotel cr = new Hotel();
            HotelDAO crdao = new HotelDAO();

            cr = crdao.findhotelById(idH);
   
                    double la=cr.getLatitude();
                    double lo=cr.getLongitude();
                    web.getEngine().executeScript("initialize("+la+","+lo+");");

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
    
    @FXML
     private void btnDownloadAction(ActionEvent event)
     {
         
         Document document = new Document();
         int idH = 0;
            
            if(FileHandler.fileExists("idH")){
                idH = Integer.valueOf(FileHandler.getText("idH"));
                
                Hotel h = new Hotel();
                HotelDAO crdao = new HotelDAO();
                
                h = crdao.findhotelById(idH);
         
        Image im=null;
         
        try {
            PdfWriter w;
            w = PdfWriter.getInstance(document, new FileOutputStream("Hotel.pdf"));
            document.open();

            
            
            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            Font fontbold = FontFactory.getFont("Times-Roman", 18, Font.BOLD);
            Chunk chunk0 = new Chunk("Détails Hotel\n\n\n");
            
            chunk0.setFont(fontbold);
            paragraph.add(chunk0);
            for (int i = 0; i<1; i++) {
                Chunk chunk1 = new Chunk("Nom: "+h.getNomHotel()+"\n\n");
                Chunk chunk2 = new Chunk("Categorie: "+h.getCategorie()+"\n\n");
                Chunk chunk3 = new Chunk("Description: "+h.getDescription()+"\n\n");
                Chunk chunk4 = new Chunk("Disponibilite: "+h.getDisponibilite()+"\n\n");
  
                paragraph.add(chunk1);
                paragraph.add(chunk2);
                paragraph.add(chunk3);
                paragraph.add(chunk4);
            }
                    try {
                        im= Image.getInstance("C:\\Users\\dell\\Desktop\\javaa\\GOVOYAGE-JAVA\\r.jpg");
                    } catch (BadElementException ex) {
                        Logger.getLogger(AfficherDetailHotelController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AfficherDetailHotelController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    im.setAbsolutePosition(140, 300);
                    PdfContentByte cb = w.getDirectContent();
                    cb.saveState();
                    cb.setColorStroke(BaseColor.BLUE);
                    cb.rectangle(10, 10, 575, 822);
                    cb.stroke();
                    cb.restoreState();
                    paragraph.add(im);
            document.add(paragraph);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
     } 
     }
    
    @FXML
    private void Ville(ActionEvent event) throws IOException {
         
       
        Parent par = FXMLLoader.load(getClass().getResource("Villeaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Sejour(ActionEvent event) throws IOException {
       
        Parent par = FXMLLoader.load(getClass().getResource("Sejouraffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
   //ok 
    @FXML
    private void Forum(ActionEvent event) throws IOException {
  
        ((Node) event.getSource()).getScene().getWindow().hide();
        User user = new User();
        if (user.getName()==null)
        {
           Parent par = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
        }
        else
        {
        Parent par = FXMLLoader.load(getClass().getResource("FXMLRéglement.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }

    }
     
}

