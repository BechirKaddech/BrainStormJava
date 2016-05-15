/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;


import com.govoyage.DAO.sejourDAO;
import com.govoyage.ENTITIES.sejour;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * FXML Controller class
 *
 * @author moez
 */
public class AfficheeController implements Initializable {

    @FXML
    private ListView showPane;
    @FXML
    private ImageView retour;
    public static int id;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        sejourDAO sjDAO = new sejourDAO();

        ObservableList<Pane> pane = FXCollections.observableArrayList();
        ArrayList<sejour> listesejour = sjDAO.displayAllsejour();

        for (int i = 0; i < listesejour.size(); i++) {
            pane.add(loadOnePays(listesejour.get(i)));
            showPane.setItems(pane);
            showPane.setSelectionModel(null);

        }

    }

    private Pane loadOnePays(sejour sj) {

        sejourDAO sjDAO = new sejourDAO();

        Pane pane = new Pane();
        Image img = new Image("/com/govoyage/IMAGES/sejour.png");
        ImageView imageView = new ImageView(img);

        pane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        pane.setPrefWidth(300);
        pane.setPrefHeight(114);
        String style = "-fx-padding: 8 15 15 15;\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 16;";
        pane.setStyle(style);
        pane.setId("pane_onePays");

        // ImageView Proprieties
        imageView.setFitHeight(65);
        imageView.setFitWidth(65);

        imageView.setLayoutX(14);
        imageView.setLayoutY(15);

        String styleNom = "\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 18;";

        Label DateDepart = new Label("DateDepart:" + sj.getDateDepart());
        Label DateArrive = new Label("DateArrive: " + sj.getDateArrive());
        Label prix = new Label("prix: " + sj.getPrix());
        Label hotel = new Label("hotel: " + sj.getHotel());
        Label ville = new Label("ville: " + sj.getVille());

        Button btn = new Button("supprimer");
        Button btn1 = new Button("Modifier");

        DateDepart.setLayoutX(93);
        DateDepart.setLayoutY(5);
        DateDepart.setId("dateDepart");

        DateArrive.setLayoutX(93);
        DateArrive.setLayoutY(25);
        DateArrive.setId("dateArrive");

        prix.setLayoutX(93);
        prix.setLayoutY(45);
        prix.setId("prix");

        hotel.setLayoutX(93);
        hotel.setLayoutY(65);
        hotel.setId("hotel");

        ville.setLayoutX(93);
        ville.setLayoutY(85);
        ville.setId("ville");

        //Button Position
        btn.setLayoutX(370);
        btn.setLayoutY(15);
        btn.setId(sj.getId() + "");
        btn.getStyleClass().add("btn-primary");

        btn1.setLayoutX(570);
        btn1.setLayoutY(15);
        btn1.setId(sj.getId() + "");
        btn1.getStyleClass().add("btn-primary");

        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                sejourDAO sejourDAO = new sejourDAO();
                sejourDAO.deleteSejour(Integer.parseInt(btn.getId()));
                 sejourDAO sjDAO = new sejourDAO();

        ObservableList<Pane> pane = FXCollections.observableArrayList();
        ArrayList<sejour> listesejour = sjDAO.displayAllsejour();

        for (int i = 0; i < listesejour.size(); i++) {
            pane.add(loadOnePays(listesejour.get(i)));
            showPane.setItems(pane);
            showPane.setSelectionModel(null);
        }

            }
        });
        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    id = Integer.parseInt(btn1.getId());
                    Parent home_page_parent = FXMLLoader.load(getClass().getResource("Sejourmodif.fxml"));
                    Scene home_page_scene = new Scene(home_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                    
                } catch (IOException ex) {
                    Logger.getLogger(AfficheeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        pane.getChildren().add(imageView);

        pane.getChildren().add(DateDepart);
        pane.getChildren().add(DateArrive);
        pane.getChildren().add(prix);
        pane.getChildren().add(hotel);
        pane.getChildren().add(ville);
        pane.getChildren().add(btn);
        pane.getChildren().add(btn1);

        return pane;

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AjourSejour.fxml"));
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
