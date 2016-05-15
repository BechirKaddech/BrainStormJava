/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;


import com.govoyage.DAO.volDAO;
import com.govoyage.ENTITIES.vol;
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
import com.govoyage.IDAO.InterfaceScreenController;
/**
 * FXML Controller class
 *
 * @author ashref
 */
public class SupprimerVolController implements Initializable , InterfaceScreenController {
    private StackEcrans stackEcrans;
     @FXML
    private ListView showPane;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ashref();
    }
    
    public void ashref(){
         
        volDAO vlDAO = new volDAO();

        ObservableList<Pane> pane = FXCollections.observableArrayList();
        ArrayList<vol> listevol = vlDAO.displayAllvol();
     
        for (int i = 0; i < listevol.size(); i++) {
                pane.add(getPaysInPane(listevol.get(i)));
        }
                showPane.setItems(pane);
                showPane.setSelectionModel(null);
            
             
        
    }
    
    
        public Pane getPaysInPane(vol vl) {
       volDAO vlDAO = new volDAO();
        Pane pane = new Pane();

        Label NomCompagnie = new Label("NomCompagnie : " + vl.getNomCompagnie());
        NomCompagnie.setLayoutX(5);
        NomCompagnie.setLayoutY(5);

        Label VilleDepart = new Label("VilleDepart : " + vl.getVilleDepart().getNom());
        VilleDepart.setLayoutX(250);
        VilleDepart.setLayoutY(5);

        Label VilleArrivee = new Label("VilleArrivee : " + vl.getVilleArrivee().getNom());
        VilleArrivee.setLayoutX(400);
        VilleArrivee.setLayoutY(5);


        Button remove = new Button("Supprimer");
        remove.setLayoutX(610);
        remove.setLayoutY(5);
        remove.getStyleClass().add("btn-danger");

        remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("ASHHHHH");
                vlDAO.deletevol(vl.getId());
                ashref();
            }
        });
        
         Button update = new Button("update");
        update.setLayoutX(700);
        update.setLayoutY(5);
        update.getStyleClass().add("btn-danger");

        update.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
 
                //System.out.println("actionee");
               // setEditcircuitPane(c); 
                
                FileHandler.saveText("idvol", String.valueOf(vl.getId()));
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("ModifVol.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(SupprimerVolController.class.getName()).log(Level.SEVERE, null, ex);
                }                
                
            }
        });

        pane.getChildren().addAll(NomCompagnie, VilleDepart, VilleArrivee, remove, update);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 5px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
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
    
        @FXML
    public void ajouter(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("AjouterVol.fxml"));
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
