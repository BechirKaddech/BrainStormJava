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
 * @author sirine
 */
public class VilleDashController implements Initializable {
    @FXML
    ListView showPane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       setVillePane();
        // TODO
    }    
    
    public void setVillePane() {
        villeDAO ville = new villeDAO();
        ArrayList<ville> listeville = ville.displayAllvilles();
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        for (int i = 0; i < listeville.size(); i++) {
            panes.add(getVilleInPane(listeville.get(i)));
        }

        showPane.setItems(panes);
        showPane.setSelectionModel(null);

       
    }
    
      public Pane getVilleInPane(ville P) {
        villeDAO pays = new villeDAO();
        Pane pane = new Pane();

        Label nom = new Label("Nom : " + P.getNom());
        nom.setLayoutX(5);
        nom.setLayoutY(5);

        Label Pays = new Label("Pays : " + P.getPays());
        Pays.setLayoutX(200);
        Pays.setLayoutY(5);
   /*     
        Label latitude = new Label("latitude : " + P.getLatitude());
        Pays.setLayoutX(700);
        Pays.setLayoutY(5);
        
        Label longitude = new Label("longitude : " + P.getLongitude());
        Pays.setLayoutX(500);
        Pays.setLayoutY(5);
        

*/
        Label description = new Label("Description : " + P.getDescription());
        description.setLayoutX(350);
        description.setLayoutY(5);
       
        Label type = new Label("Type : " + P.getType());
        type.setLayoutX(550);
        type.setLayoutY(5);

        Label languePays = new Label("Langue : " + P.getLangue());
        languePays.setLayoutX(750);
        languePays.setLayoutY(5);

        Button remove = new Button("Supprimer");
        remove.setLayoutX(950);
        remove.setLayoutY(5);
        remove.getStyleClass().add("btn-danger");
        
        Button update = new Button("Modifier");
        update.setLayoutX(1050);
        update.setLayoutY(5);
        update.getStyleClass().add("btn-danger");

        remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
               pays.deleteVille(P.getId());
                setVillePane();
            }
        });
        
          update.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
 
                try {
                    //System.out.println("actionee");
                    // setEditcircuitPane(c);

                    FileHandler.saveText("idcircuitvip", String.valueOf(P.getId()));
                    Parent root = FXMLLoader.load(getClass().getResource("VilleModif.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(VilleDashController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            }
        });

        pane.getChildren().addAll(nom ,Pays,description,type,languePays, remove, update);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 5px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
        
    }
          @FXML
    public void ajout(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("AjouterVille.fxml"));
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