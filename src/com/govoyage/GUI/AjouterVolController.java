/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.govoyage.GUI;

import com.govoyage.DAO.villeDAO;
import com.govoyage.DAO.volDAO;
import com.govoyage.ENTITIES.ville;
import com.govoyage.ENTITIES.vol;
import com.govoyage.IDAO.IvilleDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;
import org.apache.log4j.helpers.DateTimeDateFormat;
import java.sql.Date;
import com.govoyage.IDAO.InterfaceScreenController;

/**
 * FXML Controller class
 *
 * @author ashref
 */
public class AjouterVolController implements Initializable , InterfaceScreenController {
 private StackEcrans stackEcrans;
    @FXML
    private TextField nomCompagnie;

    

    

    @FXML
    private DatePicker dateDepart;

    @FXML
    private DatePicker dateArrivee;

    @FXML
    private TextField nomAeroport;
    
     @FXML
    private TextField prixVol;
    
     @FXML
     private ComboBox villeDepart;
     
      @FXML
    private ComboBox villeArrivee;

    @FXML
    private Button add;
    
    

    IvilleDAO ville = new villeDAO();  
    ArrayList<ville> listedest = ville.displayAllvilles();      
    
    @FXML
    public void AjouterVol(ActionEvent event) {

        vol h = new vol();
        volDAO hd = new volDAO();

        h.setNomCompagnie(nomCompagnie.getText());
         h.setVilleDepart(ville.findvilleBynom(villeDepart.getValue().toString()));
         h.setVilleArrivee(ville.findvilleBynom(villeArrivee.getValue().toString()));
      
        h.setDateDepart(Date.valueOf(dateDepart.getValue()));
        h.setDateArrivee(Date.valueOf(dateArrivee.getValue()));
       
        h.setPrixVol((float) Double.parseDouble(prixVol.getText()));
        h.setNomAeroport(nomAeroport.getText());

        hd.insertvol(h);
//dat=dateDepart.getValue();
     //   s.setDateDepart(Date.valueOf(dat));
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> comboVille = FXCollections.observableArrayList();
        ArrayList<ville> listeVille = ville.displayAllvilles();

        for (int i = 0; i < listeVille.size(); i++) {
            comboVille.add(listeVille.get(i).getNom());
        }   
        
        villeDepart.setItems(comboVille);         
        villeArrivee.setItems(comboVille);   
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

    @Override
    public void setScreenPane(StackEcrans screenPage) {
        stackEcrans = screenPage;
    }
    
}
