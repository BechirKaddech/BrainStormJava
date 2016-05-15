/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.circuitvipDAO;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.User;
import com.govoyage.ENTITIES.circuitvip;
import com.govoyage.ENTITIES.ville;
import com.govoyage.UTIL.FileHandler;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sirine
 */
public class VilleaffichedetailleController implements Initializable {
    @FXML
    private Label description;
    @FXML
    private Label type;
    @FXML
    private Label langue;
     @FXML
    private Label nom;
      @FXML
    private Label pays;
    @FXML
    private ImageView imag;  

    
    @FXML
    private WebView web;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
  
        int idcircuitvip = 0;
              
        
        if(FileHandler.fileExists("idcircuitvip")){
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            ville cr = new ville();
            villeDAO crdao = new villeDAO();

            cr = crdao.findvilleById(idcircuitvip);
        
        int im = crdao.findVilleImage(cr.getId());
          
        String pai = crdao.SelectImage(im);
        File f = new File("c:/wamp/www/VersionFinale/web/uploads/" + pai);
        Image img = new Image(f.toURI().toString());
        
            description.setText(cr.getDescription());
            type.setText(cr.getType());
            nom.setText(cr.getNom());
            pays.setText(cr.getPays());
            langue.setText(cr.getLangue());
            imag.setImage(img);

        }
        web.getEngine().load(getClass().getResource("mapo.html").toExternalForm());
    }
    
        @FXML
    public void tracer(ActionEvent event){
        
        int idcircuitvip = 0;
        
        if(FileHandler.fileExists("idcircuitvip")){
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            ville cr = new ville();
            villeDAO crdao = new villeDAO();

            cr = crdao.findvilleById(idcircuitvip);
   
                    double la=cr.getLatitude();
                    double lo=cr.getLongitude();
                    web.getEngine().executeScript("initialize("+la+","+lo+");");

        }
        
       

       
    }
    
    
           @FXML
    private void recherche(ActionEvent event) throws IOException {

        
        Parent par = FXMLLoader.load(getClass().getResource("RechercherVille.fxml"));
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
    private void Circuit(ActionEvent event) throws IOException {
       
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
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
  /*
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/

    } 
    
    
    
    
}
