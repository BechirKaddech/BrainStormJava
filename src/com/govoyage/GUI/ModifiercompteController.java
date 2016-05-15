/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.CompteDao;
import com.govoyage.ENTITIES.Compte;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ModifiercompteController implements Initializable {

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
     private void btnEnregistreraction(ActionEvent event)
    {
         Compte a = new Compte();
         CompteDao dao = new CompteDao();
           
         a.setEmail(email.getText());
         a.setNom(nom.getText());
         a.setPrenom(prenom.getText());
         a.setUsername(username.getText());
         a.setPassword(password.getText());
       
         dao.modifierCompte(a, LoginController.user.getId());
         ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("afficherDetailCompte.fxml"));
       try {
           loader.load();
       } catch (IOException ex) {
           Logger.getLogger(com.govoyage.GUI.ModifiercompteController.class.getName()).log(Level.SEVERE, null, ex);
       }
        Parent p =loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
