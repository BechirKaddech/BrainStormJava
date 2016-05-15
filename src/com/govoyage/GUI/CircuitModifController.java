/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.circuitvipDAO;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.circuitvip;
import com.govoyage.ENTITIES.ville;
import com.govoyage.IDAO.IvilleDAO;
import com.govoyage.UTIL.FileHandler;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class CircuitModifController implements Initializable {

    
    @FXML
    private TextField nomcircuit;
    @FXML
    private TextField latitudevd;
    @FXML
    private TextField longitudevd;
    @FXML
    private ComboBox destination1;
    @FXML
    private TextArea desc1;
    @FXML
    private TextField longitude1;
    @FXML
    private TextField latitude1;
    @FXML
    private TextArea desc2;
    @FXML
    private ComboBox destination2;
    @FXML
    private TextArea desc3;
    @FXML
    private ComboBox destination3;
    @FXML
    private TextField latitude2;
    @FXML
    private TextField longitude2;
    @FXML
    private TextField longitude3;
    @FXML
    private TextField latitude3;
    @FXML
    private DatePicker datefin;
    @FXML
    private ComboBox villedepart;
    @FXML
    private Button add;
    
    
    IvilleDAO ville = new villeDAO();  
    ArrayList<ville> listedest = ville.displayAllvilles();  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            circuitvip cr = new circuitvip();
            circuitvipDAO crdao = new circuitvipDAO();

            cr = crdao.findcircuitById(idcircuitvip);  
            
            
            
            nomcircuit.setText(cr.getNomcircuit());
            villedepart.setValue(cr.getVilledepart().getNom());
            destination1.setValue(cr.getDestination1().getNom());
            destination2.setValue(cr.getDestination2().getNom());
            destination3.setValue(cr.getDestination3().getNom());
            desc1.setText(cr.getDescription1());
            desc2.setText(cr.getDescription2());
            desc3.setText(cr.getDescription3());
            
            latitudevd.setText(String.valueOf(cr.getLatitudevd()));
            longitudevd.setText(String.valueOf(cr.getLongitudevd()));        
            latitude1.setText(String.valueOf(cr.getLatitude1()));
            longitude1.setText(String.valueOf(cr.getLongitude1()));             
            latitude2.setText(String.valueOf(cr.getLatitude2()));
            longitude2.setText(String.valueOf(cr.getLongitude2()));             
            latitude3.setText(String.valueOf(cr.getLatitude3()));
            longitude3.setText(String.valueOf(cr.getLongitude3()));             
            
        ObservableList<String> comboVille = FXCollections.observableArrayList();
        ArrayList<ville> listeVille = ville.displayAllvilles();

        for (int i = 0; i < listeVille.size(); i++) {
            comboVille.add(listeVille.get(i).getNom());
        }   
        
        villedepart.setItems(comboVille);
        
        latitudevd.setPromptText("latitudevd ..  ..");
        latitudevd.setEditable(false);
        longitudevd.setPromptText("longitudevd ..  ..");
        longitudevd.setEditable(false);
        
        latitude1.setPromptText("latitude ..  ..");
        latitude1.setEditable(false);
        longitude1.setPromptText("longitude ..  ..");
        longitude1.setEditable(false);   
        
        latitude2.setPromptText("latitude ..  ..");
        latitude2.setEditable(false);
        longitude2.setPromptText("longitude ..  ..");
        longitude2.setEditable(false);    
        
        latitude3.setPromptText("latitude ..  ..");
        latitude3.setEditable(false);
        longitude3.setPromptText("longitude ..  ..");
        longitude3.setEditable(false); 
            
            
    }
    }
    
    @FXML
    public void selectcombovd(ActionEvent event){
    
    //destination1.setVisible(false); pour cacher un element   
    //remplisage du combo de dest1    
    String vd = villedepart.getValue().toString();
    ObservableList<String> combodest1 = FXCollections.observableArrayList();
    
        int v = listedest.indexOf(ville.findvilleBynom(vd));
        listedest.remove(v);
        
        for (int i = 0; i < listedest.size(); i++) {
            combodest1.add(listedest.get(i).getNom());
        }   
        
        destination1.setItems(combodest1);
        
    //remplisage automatique des lat et long    
        
    latitudevd.setText(String.valueOf(ville.findvilleBynom(vd).getLatitude()));
    longitudevd.setText(String.valueOf(ville.findvilleBynom(vd).getLongitude()));
        
        
    }    
    
    
    @FXML
    public void selectcombodest1(ActionEvent event){
      
    String dest1 = destination1.getValue().toString();
    ObservableList<String> combodest2 = FXCollections.observableArrayList();
   
        int dest = listedest.indexOf(ville.findvilleBynom(dest1));
        listedest.remove(dest);
        
        for (int i = 0; i < listedest.size(); i++) {
            combodest2.add(listedest.get(i).getNom());
        }   
        
        destination2.setItems(combodest2);   
    
    //remplisage automatique des lat et long    
        
    latitude1.setText(String.valueOf(ville.findvilleBynom(dest1).getLatitude()));
    longitude1.setText(String.valueOf(ville.findvilleBynom(dest1).getLongitude()));    
        
    }
    
    @FXML
    public void selectcombodest2(ActionEvent event){
      
    String dest2 = destination2.getValue().toString();
    ObservableList<String> combodest3 = FXCollections.observableArrayList();
   
        int dest = listedest.indexOf(ville.findvilleBynom(dest2));
        listedest.remove(dest);
        
        for (int i = 0; i < listedest.size(); i++) {
            combodest3.add(listedest.get(i).getNom());
        }   
        
        destination3.setItems(combodest3);   
    
    //remplisage automatique des lat et long    
        
    latitude2.setText(String.valueOf(ville.findvilleBynom(dest2).getLatitude()));
    longitude2.setText(String.valueOf(ville.findvilleBynom(dest2).getLongitude()));    
        
    }    
    
    @FXML
    public void selectcombodest3(ActionEvent event){
        
    String dest2 = destination3.getValue().toString();    
        
    //remplisage automatique des lat et long    
        
    latitude3.setText(String.valueOf(ville.findvilleBynom(dest2).getLatitude()));
    longitude3.setText(String.valueOf(ville.findvilleBynom(dest2).getLongitude()));     
        
    } 
    
    @FXML
    public void update(ActionEvent event) throws IOException{
        
     int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            circuitvip cr = new circuitvip();
            circuitvipDAO crdao = new circuitvipDAO();

            cr = crdao.findcircuitById(idcircuitvip);          
        
        circuitvip h = new circuitvip();
        circuitvipDAO hd = new circuitvipDAO();
                 
        h.setNomcircuit(nomcircuit.getText());
        
        h.setVilledepart(ville.findvilleBynom(villedepart.getValue().toString()));
        h.setDestination1(ville.findvilleBynom(destination1.getValue().toString()));
        h.setDestination2(ville.findvilleBynom(destination2.getValue().toString()));
        h.setDestination3(ville.findvilleBynom(destination3.getValue().toString()));
        
      
        h.setDescription1(desc1.getText());
        h.setDescription2(desc2.getText());
        h.setDescription3(desc3.getText());        
        
        
       // h.setDatefin(java.sql.Date.valueOf(datefin.getValue()));
        
        h.setLatitudevd(Double.parseDouble(latitudevd.getText()));
        h.setLongitudevd(Double.parseDouble(longitudevd.getText()));
        h.setLatitude1(Double.parseDouble(latitude1.getText()));
        h.setLongitude1(Double.parseDouble(longitude1.getText()));
        h.setLatitude2(Double.parseDouble(latitude2.getText()));
        h.setLongitude2(Double.parseDouble(longitude2.getText()));
        h.setLatitude3(Double.parseDouble(latitude3.getText()));
        h.setLongitude3(Double.parseDouble(longitude3.getText()));        
        h.setId(cr.getId());
      
        if (hd.updateCircuitvip(h)) {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("CircuitDash.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

                }
        
    }}
    
    @FXML
    public void dasho(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void dashcircuit(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("CircuitDash.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    


    
    
    
}
