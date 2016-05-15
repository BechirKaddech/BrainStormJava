/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;


import com.govoyage.DAO.HotelDAO;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.Hotel;
import com.govoyage.ENTITIES.ville;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Firasss
 */
public class Ajout extends Application{
    ComboBox<String> b;
    List<ville> list;
    
    public static void main(String[] args) {
	Application.launch(Ajout.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        villeDAO vdao = new villeDAO();
        list = new ArrayList<>();
        list = vdao.AfficherVille();
        
        VBox v = new VBox(20);
        HBox h1 = new HBox(95);
        HBox h2 = new HBox(55);
        HBox h3 = new HBox(30);
        HBox h4 = new HBox(40);
        HBox h5 = new HBox(110);
        HBox h6 = new HBox(105);
        Scene sc = new Scene(v,900,600);
        
        Label l1 = new Label("Nom");
        Label l2 = new Label("Categorie");
        Label l3 = new Label("Disponibilité");
        Label l4 = new Label("Description");
        Label l5 = new Label("Prix");
        Label l6 = new Label("Ville");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        TextField t5 = new TextField();
        
        b = new ComboBox<>();
        b.setMinWidth(205);
        b.setMinHeight(35);
        for(int i=0;i<list.size();i++){
           b.getItems().add(list.get(i).getNom());
        }
        
        
        Button ajouter = new Button("ajouter");
        ajouter.setMinWidth(200);
        ajouter.getStyleClass().add("button-add");
        ajouter.setOnAction(e ->{ 
            Hotel h = new Hotel();
            HotelDAO hd = new HotelDAO();
            h.setDescription(t4.getText());
            h.setNomHotel(t1.getText());
            h.setCategorie(t2.getText());
            h.setDisponibilite(t3.getText());
            h.setPrix(Integer.parseInt(t5.getText()));
            h.setVille_id(vdao.returnid(b.getSelectionModel().getSelectedItem()));
            hd.AjouterHotel(h);
        });
        
        h1.getChildren().addAll(l1,t1);
        h2.getChildren().addAll(l2,t2);
        h3.getChildren().addAll(l3,t3);
        h4.getChildren().addAll(l4,t4);
        h5.getChildren().addAll(l5,t5);
        h6.getChildren().addAll(l6,b);
        v.getChildren().addAll(h1,h2,h3,h4,h5,h6,ajouter);
        
        sc.getStylesheets().add("Ressources/JavaFX.css");
        stage.setScene(sc);
        v.setAlignment(Pos.CENTER);
        v.setFillWidth(false);
        stage.show();
    }
    
}
