/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.ENTITIES.User;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
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
 *
 * @author user
 */
public class FXMLLoginTestController implements Initializable {
      @FXML
               private TextField l1;
                   @FXML
               private TextField l2;
                    @FXML
               private TextField l3;
    @FXML
    private void login(ActionEvent et) throws IOException {
        User user = new User();
        user.setId(parseInt(l1.getText()));
        user.setName(l2.getText());
        user.setRole(l3.getText());
        
            System.out.println("Test test");
            System.out.println(user.getName());
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLRéglement.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) et.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
  
    }

    

