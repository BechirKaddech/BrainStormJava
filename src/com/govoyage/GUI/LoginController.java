/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;


import com.govoyage.DAO.CompteDao;
import com.govoyage.ENTITIES.Compte;
import com.govoyage.ENTITIES.User;
import javafx.event.ActionEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fadoua
 */
public class LoginController implements Initializable {

    static String USERNAME;
    static Compte user;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label label;

    @FXML

    private void btnloginaction(ActionEvent event) throws IOException {
        String role;
        String ROLE;
        

        CompteDao dao = new CompteDao();
       // user = dao.veriflogin(username.getText(), password.getText());
        role = dao.veriflogin2(username.getText(), password.getText());
        user=dao.getCompte(username.getText(), password.getText());
        System.out.println(user);
        

        if (role != null) {

            System.out.println(role);
            ROLE = role.substring(15, 25);
            System.out.println(ROLE);
            
            if (ROLE.equals("ROLE_ADMIN")) {
                
                
                //add By Bechir
                   User user = new User();
       
        user.setName(username.getText());
        user.setRole(ROLE);
                
                
                
                ((Node) event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource("dashi.fxml"));
                loader.load();
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                

            } else if (ROLE.equals("ROLE_ABONN")) {

                   User user = new User();
       
        user.setName(username.getText());
        user.setRole(ROLE);
                
                ((Node) event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Home.fxml"));
                loader.load();
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
            } else {
                System.out.println("boo");
            }

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Votre login ou mot de passe est incorrect !");

            alert.showAndWait();
        }
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
