/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;


import com.govoyage.DAO.GestionGarage;
import com.govoyage.ENTITIES.Garage;
import com.govoyage.IDAO.IGestionGarage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alaa
 */
public class GarageController implements Initializable {
public int currentID;
    private TextField nomVoiture;
    private TextField capacite;
    @FXML
    private TextField emplacement;
    IGestionGarage garageDAO = new GestionGarage();
    @FXML
    private TextField nomGarage;
    @FXML
    private TextField capaciteGarage;
    @FXML
    private TableView<Garage> table;
    @FXML
    private TableColumn<Garage, String> CNom=new TableColumn();
    @FXML
    private TableColumn<Garage, String> CCapacite=new TableColumn();
    @FXML
    private TableColumn<Garage, String> Cemplacement=new TableColumn();
    @FXML
    private Button GVoitures;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GestionGarage g = new GestionGarage();
        List<Garage> l = new ArrayList<>();
        
        l = g.AfficherGarage();
        
        final ObservableList<Garage> data = FXCollections.observableArrayList();
        for (Garage m1 : l) {

            data.add(m1);

        }
        
        CNom.setCellValueFactory(new PropertyValueFactory<>("nom_garage"));
        CCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        Cemplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement_voiture"));
        
        table.setItems(data);
        
        
        table.setItems(data);
        
table.setRowFactory( tv -> {
    TableRow<Garage> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
            Garage rowData = row.getItem();
        currentID=rowData.getId();
        nomGarage.setText(rowData.getNom_garage());
        capaciteGarage.setText(String.valueOf(rowData.getCapacite()));
       emplacement.setText(String.valueOf(rowData.getEmplacement_voiture()));
        
        
        }
    });
    return row ;
}); 
    }    
    
    public void afficheGarage(){
        GestionGarage g = new GestionGarage();
        List<Garage> l = new ArrayList<>();
        
        l = g.AfficherGarage();
        
        final ObservableList<Garage> data = FXCollections.observableArrayList();
        for (Garage m1 : l) {

            data.add(m1);

        }
        
        CNom.setCellValueFactory(new PropertyValueFactory<>("nom_garage"));
        CCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        Cemplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement_voiture"));
        
        table.setItems(data);
    }
    
    public void addGarage(ActionEvent event){
        Garage garage = new Garage(nomVoiture.getText(), Integer.parseInt(capacite.getText()), Integer.parseInt(emplacement.getText()));
        garageDAO.AjouterGarage(garage);
        //afficheGarage();
    }

    @FXML
    private void AjouterGarage(ActionEvent event) {
        Garage garage = new Garage(nomGarage.getText(), Integer.parseInt(capaciteGarage.getText()), Integer.parseInt(emplacement.getText()));
        garageDAO.AjouterGarage(garage);
        afficheGarage();
    }

    @FXML
    private void modifierGarage(ActionEvent event) {
        garageDAO.ModifierGarage(new Garage(currentID,nomGarage.getText(), Integer.parseInt(capaciteGarage.getText()), Integer.parseInt(emplacement.getText())));
       afficheGarage();
    }

    @FXML
    private void SupprimerGarage(ActionEvent event) {
        garageDAO.supprimerGarage(currentID);
        afficheGarage();
    }

    @FXML
    private void GestionVoitures(ActionEvent event) throws IOException {
     
    /* navigation*/
       



        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("/com/govoyage/GUI/VoitureLocation.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


        
       
        
      
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
