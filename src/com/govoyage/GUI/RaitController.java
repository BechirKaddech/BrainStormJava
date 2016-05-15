/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.HotelDAO;
import com.govoyage.DAO.volDAO;
import com.govoyage.ENTITIES.Hotel;
import com.govoyage.ENTITIES.User;
import com.govoyage.ENTITIES.vol;
import com.govoyage.GUI.ModifVolController;
import com.govoyage.UTIL.FileHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.govoyage.IDAO.InterfaceScreenController;
import com.govoyage.ServiceTraduction.ApiKeys;
import com.govoyage.ServiceTraduction.Language;
import com.govoyage.ServiceTraduction.Translate;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Fadoua
 */
public class RaitController implements Initializable , InterfaceScreenController{
  private StackEcrans stackEcrans;
     @FXML
    ImageView etoileon1;
    @FXML
    ImageView etoileon2;
    @FXML
    ImageView etoileon3;
    @FXML
    ImageView etoileon4;
    @FXML
    ImageView etoileon5;
    
    @FXML
    ImageView etoileoff1;
    @FXML
    ImageView etoileoff2;
    @FXML
    ImageView etoileoff3;
    @FXML
    ImageView etoileoff4;
    @FXML
    ImageView etoileoff5;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        etoileon1.setVisible(false);
        etoileon2.setVisible(false);        
        etoileon3.setVisible(false);
        etoileon4.setVisible(false);
        etoileon5.setVisible(false);
        etoileoff1.setVisible(true);
        etoileoff2.setVisible(true);        
        etoileoff3.setVisible(true);
        etoileoff4.setVisible(true);
        etoileoff5.setVisible(true);
        
    }   

   
    
    @FXML
    private void etoileoff1MouseMoved(MouseEvent arg0) { 
        
                etoileon1.setVisible(false);
                etoileon2.setVisible(false);
                etoileon3.setVisible(false);
                etoileon4.setVisible(false);
                etoileon5.setVisible(false);
                etoileon1.setVisible(true);
            
        
    } 
    
    @FXML
    private void etoileoff2MouseMoved(MouseEvent arg0) { 
        
                etoileon1.setVisible(false);
                etoileon2.setVisible(false);
                etoileon3.setVisible(false);
                etoileon4.setVisible(false);
                etoileon5.setVisible(false);
                etoileon1.setVisible(true);
                etoileon2.setVisible(true);
         
    } 
    
    @FXML
    private void etoileoff3MouseMoved(MouseEvent arg0) { 
        
                etoileon1.setVisible(false);
                etoileon2.setVisible(false);
                etoileon3.setVisible(false);
                etoileon4.setVisible(false);
                etoileon5.setVisible(false);
                etoileon1.setVisible(true);
                etoileon2.setVisible(true);
                etoileon3.setVisible(true);
           
        
    } 
    @FXML
    private void etoileoff4MouseMoved(MouseEvent arg0) { 
       
                etoileon1.setVisible(false);
                etoileon2.setVisible(false);
                etoileon3.setVisible(false);
                etoileon4.setVisible(false);
                etoileon5.setVisible(false);
                etoileon1.setVisible(true);
                etoileon2.setVisible(true);
                etoileon3.setVisible(true);
                etoileon4.setVisible(true);
         
        
    } 
    
    @FXML
    private void etoileoff5MouseMoved(MouseEvent arg0) { 
      
                etoileon1.setVisible(false);
                etoileon2.setVisible(false);
                etoileon3.setVisible(false);
                etoileon4.setVisible(false);
                etoileon5.setVisible(false);
                etoileon1.setVisible(true);
                etoileon2.setVisible(true);
                etoileon3.setVisible(true); 
                etoileon4.setVisible(true);
                etoileon5.setVisible(true);
        
    } 
    
    @FXML
    private void etoileon1MouseMoved(MouseEvent arg0) {                                     
        etoileon1.setVisible(false);
        etoileon2.setVisible(false);
        etoileon3.setVisible(false);
        etoileon4.setVisible(false);
        etoileon5.setVisible(false);
       
        etoileon1.setVisible(true);
    }                                    
    
    @FXML
    private void etoileon2MouseMoved(MouseEvent arg0) {                                     
        etoileon1.setVisible(false);
        etoileon2.setVisible(false);
        etoileon3.setVisible(false);
        etoileon4.setVisible(false);
        etoileon5.setVisible(false);
      
        etoileon1.setVisible(true);
        etoileon2.setVisible(true);
    }                                    
    
    @FXML
    private void etoileon3MouseMoved(MouseEvent arg0) {                                     
        etoileon1.setVisible(false);
        etoileon2.setVisible(false);
        etoileon3.setVisible(false);
        etoileon4.setVisible(false);
        etoileon5.setVisible(false);
       
        etoileon1.setVisible(true);
        etoileon2.setVisible(true);
        etoileon3.setVisible(true);
    }                                    
    
    @FXML
    private void etoileon4MouseMoved(MouseEvent arg0) {                                     
        etoileon1.setVisible(false);
        etoileon2.setVisible(false);
        etoileon3.setVisible(false);
        etoileon4.setVisible(false);
        etoileon5.setVisible(false);
        
        etoileon1.setVisible(true);
        etoileon2.setVisible(true);
        etoileon3.setVisible(true);
        etoileon4.setVisible(true);
    }                                    
    
    @FXML
    private void etoileon5MouseMoved(MouseEvent arg0) {                                     
        etoileon1.setVisible(false);
        etoileon2.setVisible(false);
        etoileon3.setVisible(false);
        etoileon4.setVisible(false);
        etoileon5.setVisible(false);
        
        etoileon1.setVisible(true);
        etoileon2.setVisible(true);
        etoileon3.setVisible(true);
        etoileon4.setVisible(true);
        etoileon5.setVisible(true);
    }  
    
    @FXML
    private void etoileon1MouseReleased(MouseEvent arg0) {                                     
      
        int idvol = 0;
        if (FileHandler.fileExists("id")) {
            idvol = Integer.valueOf(FileHandler.getText("id"));
        volDAO h = new volDAO();
        vol h1 = h.findvolById(idvol);
        h1.setNote(1);
        h.updatevol(h1);
    }  
    }
    
    @FXML
    private void etoileon2MouseReleased(MouseEvent arg0) {                                     
       int idvol = 0;
        if (FileHandler.fileExists("id")) {
            idvol = Integer.valueOf(FileHandler.getText("id"));
        volDAO h = new volDAO();
        vol h1 = h.findvolById(idvol);
        h1.setNote(2);
        h.updatevol(h1);
    }  
    }  
    
    @FXML
    private void etoileon3MouseReleased(MouseEvent arg0) {                                     
        int idvol = 0;
        if (FileHandler.fileExists("id")) {
            idvol = Integer.valueOf(FileHandler.getText("id"));
        volDAO h = new volDAO();
        vol h1 = h.findvolById(idvol);
        h1.setNote(3);
        h.updatevol(h1);
    }  
    }  
    
    @FXML
    private void etoileon4MouseReleased(MouseEvent arg0) {                                     
        int idvol = 0;
        if (FileHandler.fileExists("id")) {
            idvol = Integer.valueOf(FileHandler.getText("id"));
        volDAO h = new volDAO();
        vol h1 = h.findvolById(idvol);
        h1.setNote(4);
        h.updatevol(h1);
    }  
    }  
    
    @FXML
    private void etoileon5MouseReleased(MouseEvent arg0) {                                     
       int idvol = 0;
        if (FileHandler.fileExists("id")) {
            idvol = Integer.valueOf(FileHandler.getText("id"));
        volDAO h = new volDAO();
        vol h1 = h.findvolById(idvol);
        h1.setNote(5);
        h.updatevol(h1);
    }  
    }  

    @Override
    public void setScreenPane(StackEcrans screenPage) {
        stackEcrans = screenPage;
    }
    
    
    
    @FXML
    private void home(ActionEvent event) throws IOException { 
      
        Parent par = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }    
    
        @FXML
    private void Acceuil(ActionEvent event) throws IOException {
        
        Parent par = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Hotel(ActionEvent event) throws IOException {
     
        Parent par = FXMLLoader.load(getClass().getResource("Hotelaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Vol(ActionEvent event) throws IOException {
       
        
        Parent par = FXMLLoader.load(getClass().getResource("Volaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

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
    
    @FXML
    private void Circuit(ActionEvent event) throws IOException {
       
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    } 
    
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
    
    @FXML
    private void Voiture(ActionEvent event) throws IOException {
     /*   ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/

    }  
    
}
