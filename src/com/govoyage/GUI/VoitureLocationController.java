/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;


import com.govoyage.DAO.GestionGarage;
import com.govoyage.DAO.GestionVoiture;
import com.govoyage.ENTITIES.Garage;
import com.govoyage.ENTITIES.Voiture;
import com.govoyage.IDAO.IGestionGarage;
import com.govoyage.IDAO.IGestionVoiture;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alaa
 */
public class VoitureLocationController implements Initializable {
public int currentID;
    @FXML
    private TextField marqueTF;
    @FXML
    private TextField matriculeTF;
    @FXML
    private TextField modelTF;
    @FXML
    private TextField prixTF;
    @FXML
    public ComboBox<String> disponibiliteCB;
public IGestionVoiture gestionVoiture=new GestionVoiture();
    @FXML
    public TableView<Voiture> table;
    @FXML
    private TableColumn <Voiture,String> matCell=new TableColumn() ;
    @FXML
    private TableColumn<Voiture,String> marCell=new TableColumn() ;
    @FXML
    private TableColumn<Voiture,String> modCell=new TableColumn() ;
    @FXML
    private TableColumn<Voiture,Float> prixCell;
    @FXML
    private TableColumn<Voiture,String>etatCell;
    @FXML
    private TextField rechTxt;
    @FXML
    private ComboBox<Garage> garageCB;
   
    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
         
       ObservableList<String> options= FXCollections.observableArrayList(
        "disponible",
        "non disponible"
     
    );
        disponibiliteCB.setItems(options);
        // garage combobox
       IGestionGarage gestionGarage=new GestionGarage();
        List<Garage> listGarage = gestionGarage.AfficherGarage();

    ObservableList<Garage> observableList = FXCollections.observableList(listGarage);
        garageCB.setItems(observableList);
        // garage combobox
        
        
 GestionVoiture m = new GestionVoiture();
        List<Voiture> l = new ArrayList<>();
     
       
        l = m.AfficherVoiture();
       
        final ObservableList<Voiture> data = FXCollections.observableArrayList();
        for (Voiture m1 : l) {

            data.add(m1);

        }
//        
       
       // table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        matCell.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        marCell.setCellValueFactory(new PropertyValueFactory<>("marque"));
                modCell.setCellValueFactory(new PropertyValueFactory<>("model"));
                
                prixCell.setCellValueFactory(new PropertyValueFactory<>("prix"));
                 etatCell.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));

       table.setItems(data);
table.setRowFactory( tv -> {
    TableRow<Voiture> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
            Voiture rowData = row.getItem();
        currentID=rowData.getId();
        marqueTF.setText(rowData.getMarque());
        matriculeTF.setText(rowData.getMatricule());
        modelTF.setText(rowData.getModel());
        prixTF.setText(String.valueOf(rowData.getPrix()));
        disponibiliteCB.setValue(rowData.getDisponibilite());
        
        
        }
    });
    return row ;
});            
    
    }
 @FXML
    public void ajouterVoiture(ActionEvent event)
    {IGestionGarage gestionGarage=new GestionGarage();
        List<Garage> listGarage = gestionGarage.AfficherGarage();

        int idGarage=listGarage.get(garageCB.getSelectionModel().getSelectedIndex()).getId();
    gestionVoiture.AjouterVoiture(new Voiture(matriculeTF.getText(),marqueTF.getText(),modelTF.getText(),Float.parseFloat(prixTF.getText()),disponibiliteCB.getSelectionModel().getSelectedItem(),idGarage));
    afficherVoiture();
    }
    
    public void afficherVoiture() {
        
         GestionVoiture m = new GestionVoiture();
        List<Voiture> l = new ArrayList<>();
     
       
        l = m.AfficherVoiture();
       
        final ObservableList<Voiture> data = FXCollections.observableArrayList();
        for (Voiture m1 : l) {

            data.add(m1);

        }
//        
       
       // table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        matCell.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        marCell.setCellValueFactory(new PropertyValueFactory<>("marque"));
                modCell.setCellValueFactory(new PropertyValueFactory<>("model"));
                
                prixCell.setCellValueFactory(new PropertyValueFactory<>("prix"));
                 etatCell.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));
               
table.setItems(data);
    }

    @FXML
    private void modifierVoiture(ActionEvent event) {
        
        gestionVoiture.ModifierVoiture(new Voiture(currentID,matriculeTF.getText(),marqueTF.getText(),modelTF.getText(),Float.parseFloat(prixTF.getText()), disponibiliteCB.getSelectionModel().getSelectedItem()));
       afficherVoiture();
    }

    @FXML
    private void supprimerVoiture(ActionEvent event) {
    
    gestionVoiture.supprimerVoiture(currentID);
    afficherVoiture();
    }

    @FXML
    private void findBy(KeyEvent event) {
        
          GestionVoiture m = new GestionVoiture();
        List<Voiture> l = new ArrayList<>();
     
       
        l = m.RechercherVoiture(rechTxt.getText());
       
        final ObservableList<Voiture> data = FXCollections.observableArrayList();
        for (Voiture m1 : l) {

            data.add(m1);

        }
//        
       
       // table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        matCell.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        marCell.setCellValueFactory(new PropertyValueFactory<>("marque"));
                modCell.setCellValueFactory(new PropertyValueFactory<>("model"));
                
                prixCell.setCellValueFactory(new PropertyValueFactory<>("prix"));
                 etatCell.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));
               
table.setItems(data);
    }

    @FXML
    private void retourGarage(ActionEvent event) throws IOException {
    
     ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("/presentations/Garage.fxml"));
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
