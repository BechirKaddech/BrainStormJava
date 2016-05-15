/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.ReclamationDao;
import com.govoyage.ENTITIES.Reclamation;
import com.govoyage.UTIL.FileHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class FXMLReclamationController implements Initializable {

    @FXML
    private TextField t1;
    @FXML
    private TextArea t2;
    @FXML
    private Button b1;
    @FXML
    private Label l1;

    public void addrec(ActionEvent a) {
        Reclamation reclamation = new Reclamation();
        ReclamationDao reclamationDao = new ReclamationDao();
        reclamation.setTitre(t1.getText());
        reclamation.setContenu(t2.getText());
        reclamationDao.addReclamation(reclamation);
      
        l1.setText("Réclamation envoyé ! ");
        


    }
            @FXML
    private void forum(ActionEvent r) throws IOException {
      
       
         
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAccepterReg.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) r.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
