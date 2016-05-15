/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.ENTITIES.User;
import com.govoyage.ServiceTraduction.ApiKeys;
import com.govoyage.ServiceTraduction.Language;
import com.govoyage.ServiceTraduction.Translate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class TraductionsController implements Initializable {

    @FXML
    private TextArea champs;
    
    @FXML
    private TextArea tradi;    
    
    @FXML
    private Button bouton;
   
    
    @FXML
    Pane showPane;
    
    @FXML
    private ComboBox langue1;
    
    @FXML
    private ComboBox langue2;
    


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> lan = FXCollections.<String>observableArrayList();
        lan.add("ENGLISH");
        lan.add("FRENCH");
        lan.add("Arabic");
        langue1.setItems(lan);
        
        ObservableList<String> lan2 = FXCollections.<String>observableArrayList();
        lan2.add("ENGLISH");
        lan2.add("FRENCH");
        lan2.add("Arabic");
        langue2.setItems(lan2);
        
    }
  /*  

    @FXML
    private void combo1(ActionEvent event) throws Exception{
        

               String langue =  langue1.getValue().toString();  
               Language languee = Language.;
               System.out.println(langue);//mochkel :v ey la7dha zid 5amem enti  
            

    }       */      
    

    

          
    @FXML
    private void trados(ActionEvent event) throws Exception{
        
      String cont=champs.getText();
            
      Translate.setKey(ApiKeys.YANDEX_API_KEY);
 
      String desti=langue2.getValue().toString();
      String sort =langue1.getValue().toString();
      
      String translation = Translate.execute(cont,Language.valueOf(sort) , Language.valueOf(desti));
      System.out.println("Translation: " + translation);
      
      tradi.setText(translation);
                   
            

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
