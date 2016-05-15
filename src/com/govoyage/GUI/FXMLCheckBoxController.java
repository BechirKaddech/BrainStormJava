/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class FXMLCheckBoxController implements Initializable {
    public void valider ( ActionEvent a) {
       Stage stage = (Stage) ((Node) a.getSource()).getScene().getWindow();
       stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
