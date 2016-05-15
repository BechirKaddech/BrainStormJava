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
import java.time.format.DateTimeFormatterBuilder;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saidi
 */
public class AjourSejourController implements Initializable {
    private TextField t4;
    @FXML
    private DatePicker t1;
    @FXML
    private DatePicker t2;
    @FXML
    private TextField t3;
    @FXML
    private Button l1;
    @FXML
    private ComboBox<Hotel> c1;
    @FXML
    private ComboBox<ville> c2;
    LocalDate dat ;
    
    @FXML
    
    public void AjouteSejour(ActionEvent event){
        sejour s = new sejour();
        sejourDAO sd= new sejourDAO(); 
       dat=t1.getValue();
        s.setDateDepart(Date.valueOf(dat));
        dat=t2.getValue();
      s.setDateArrive(Date.valueOf(dat));
        s.setPrix(Double.parseDouble(t3.getText()));
        s.setHotel(c1.getValue());
        s.setVille(c2.getValue());
sd.add(s);        
        
    }
        @FXML
   public void handle1(ActionEvent e) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("Affichee.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();}
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.setItems(FXCollections.observableArrayList(new HotelDAO().displayAllhotel()));
        c2.setItems(FXCollections.observableArrayList(new villeDAO().displayAllvilless()));
        
    }    

    private int Int(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
