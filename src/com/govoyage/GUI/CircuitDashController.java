/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.circuitvipDAO;
import com.govoyage.ENTITIES.circuitvip;
import com.govoyage.UTIL.FileHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class CircuitDashController implements Initializable {
    
    @FXML
    private ListView showPane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            hedi();
    

    }
    
    public void hedi(){
         
        circuitvipDAO crDAO = new circuitvipDAO();

        ObservableList<Pane> pane = FXCollections.observableArrayList();
        ArrayList<circuitvip> listecircuit = crDAO.displayAllcircuitsVip();
     
        for (int i = 0; i < listecircuit.size(); i++) {
                pane.add(getPaysInPane(listecircuit.get(i)));
        }
                showPane.setItems(pane);
                showPane.setSelectionModel(null);
           
    }
        
    
    
    
        public Pane getPaysInPane(circuitvip c) {
        circuitvipDAO crDAO = new circuitvipDAO();
        
           /* String hedi=String.valueOf(c.getDatefin());
            String year = hedi.substring(0,2);
            int he =Integer.parseInt(year);
            System.out.println(he);*/
  
        Pane pane = new Pane();

        Label nomPays = new Label("NomCircuit : " + c.getNomcircuit());
        nomPays.setLayoutX(5);
        nomPays.setLayoutY(5);

        Label capitalePays = new Label("villedp : " + c.getVilledepart().getNom());
        capitalePays.setLayoutX(300);
        capitalePays.setLayoutY(5);

        Label languePays = new Label("destination1 : " + c.getDestination1().getNom());
        languePays.setLayoutX(600);
        languePays.setLayoutY(5);
        
        Label lat = new Label("destination2 : " + c.getDestination2().getNom());
        lat.setLayoutX(900);
        lat.setLayoutY(5);
        
        Label lon = new Label("destination3 : " +c.getDestination3().getNom());
        lon.setLayoutX(1200);
        lon.setLayoutY(5);
        



        Button remove = new Button("Supprimer");
        remove.setLayoutX(1500);
        remove.setLayoutY(5);
        remove.getStyleClass().add("btn-danger");
        
        Button modif = new Button("MOdifier");
        modif.setLayoutX(1800);
        modif.setLayoutY(5);
        modif.getStyleClass().add("btn-danger");

        remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                crDAO.deleteCircuitvip(c.getId());
                hedi();
            }
        });

        modif.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
 
                //System.out.println("actionee");
               // setEditcircuitPane(c); 
                
                FileHandler.saveText("idcircuitvip", String.valueOf(c.getId()));
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("CircuitModif.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(CircuitaffichetoutController.class.getName()).log(Level.SEVERE, null, ex);
                }                
                
            }
        });
        
        pane.getChildren().addAll(nomPays, capitalePays,languePays,lat ,lon,remove, modif);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 5px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
    }   
        
    @FXML
    public void ajout(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Ajoutcircuit.fxml"));
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
