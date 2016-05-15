/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.AbonneDao;
import com.govoyage.ENTITIES.Abonne;
import com.govoyage.IDAO.AbonneIDAO;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class InscriptionutilController implements Initializable {


   @FXML
    private TextField username;

    @FXML
    private TextField nom;
    
    @FXML
    private TextField prenom;

    @FXML
    private TextField email;
    

    @FXML
    private TextField password;

    @FXML
    private Label label;
    
     @FXML
    private void btnEnregistreraction(ActionEvent event)
    {
         Abonne a = new Abonne();
         AbonneIDAO dao = new AbonneDao();
           
         a.setEmail(email.getText());
         a.setNom(nom.getText());
         a.setPrenom(prenom.getText());
         a.setUsername(username.getText());
         a.setPassword(password.getText());
       
         dao.insertAbonne(a);
    }
    
     @FXML
    private void accueilAction(ActionEvent event) throws IOException
    { 
     ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));
        loader.load();
        Parent p =loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    

}
