/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.HotelDAO;
import com.govoyage.DAO.sejourDAO;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.Hotel;
import com.govoyage.ENTITIES.sejour;
import com.govoyage.ENTITIES.ville;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class SejourmodifController implements Initializable {

    sejourDAO sejourDAO = new sejourDAO();
    sejour se = new sejour();
    LocalDate dat;

    @FXML
    private TextField t3;
    @FXML
    private ComboBox<Hotel> c1;
    @FXML
    private ComboBox<ville> c2;
    @FXML
    private DatePicker t1;
    @FXML
    private DatePicker t2;
    @FXML
    private Button l1;
    
    @FXML
    private Button precedent;

    private int Int(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c1.setItems(FXCollections.observableArrayList(new HotelDAO().displayAllhotel()));
        c2.setItems(FXCollections.observableArrayList(new villeDAO().displayAllvilless()));
        sejourDAO sejourDAO = new sejourDAO();
        sejour se = new sejour();
        se = sejourDAO.findsejourById(AfficheeController.id);
        t3.setText(String.valueOf(se.getPrix()));
        c1.setValue(se.getHotel());
        c2.setValue(se.getVille());

    }



    @FXML
    private void modifiersejour(ActionEvent event) throws IOException {
        se.setId(AfficheeController.id);
        dat = t1.getValue();
        se.setDateDepart(Date.valueOf(dat));
        dat = t2.getValue();
        se.setDateArrive(Date.valueOf(dat));
        se.setPrix(Double.parseDouble(t3.getText()));
        se.setHotel(c1.getValue());
        se.setVille(c2.getValue());
        sejourDAO.updateSejour(se);
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Affichee.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }  
    
    
        @FXML
    public void dasho(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("dashi.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
