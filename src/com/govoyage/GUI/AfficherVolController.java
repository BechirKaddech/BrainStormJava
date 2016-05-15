/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.volDAO;
import com.govoyage.ENTITIES.vol;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import com.govoyage.IDAO.InterfaceScreenController;
/**
 * FXML Controller class
 *
 * @author ashref
 */
public class AfficherVolController implements Initializable , InterfaceScreenController{
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
        
        volDAO vlDAO = new volDAO();

        ObservableList<Pane> pane = FXCollections.observableArrayList();
        ArrayList<vol> listevol = vlDAO.displayAllvol();
     
        for (int i = 0; i < listevol.size(); i++) {
                pane.add(loadOnePays(listevol.get(i))); 
                showPane.setItems(pane);
                showPane.setSelectionModel(null);
            
             }
           
        }        
   
    
    
    private Pane loadOnePays(vol vl) {

        volDAO vlDAO = new volDAO();

        Pane pane = new Pane(); 
        Image img = new Image("/com/govoyage/IMAGES/vol.png");
        ImageView imageView = new ImageView(img);

        // Pane Size
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

        Label Compagnie = new Label(vl.getNomCompagnie());
        Label VilleDepart = new Label("VilleDepart:"+vl.getVilleDepart().getNom());
        Label VilleArrivee = new Label("VilleArrivee: "+vl.getVilleArrivee().getNom());
        Label DateDepart = new Label("DateDepart: "+vl.getDateDepart());
         Label DateArrivee = new Label("DateArrivee: "+vl.getDateArrivee());
  
        Button btn = new Button("aller");

        // Label Proprieties
        //nom_pays.setPrefSize(314, 61);
        Compagnie.setStyle(styleNom);
        Compagnie.setLayoutX(88);
        Compagnie.setLayoutY(5);
        Compagnie.setId("Compagnie");
        
        VilleDepart.setLayoutX(93);
        VilleDepart.setLayoutY(30);
        VilleDepart.setId("VilleDepart");

        VilleArrivee.setLayoutX(93);
        VilleArrivee.setLayoutY(50);
        VilleArrivee.setId("VilleArrivee");
        
        DateDepart.setLayoutX(93);
        DateDepart.setLayoutY(70);
        DateDepart.setId("DateDepart");
        
        DateArrivee.setLayoutX(93);
        DateArrivee.setLayoutY(90);
        DateArrivee.setId("DateArrivee");
        
     
        
        // Button Position
        btn.setLayoutX(270);
        btn.setLayoutY(15);
        btn.setId("btn_visiter");
        btn.getStyleClass().add("btn-primary");
        /*
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                FileHandler.saveText("idPays", String.valueOf(idPays));
                try {
                    stackEcrans.loadScreen("affichePays", "AfficherPays.fxml");
                } catch (Exception ex) {
                    Logger.getLogger(AfficherTousPaysController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stackEcrans.setScreen("affichePays");
            }
        });*/

        pane.getChildren().add(imageView);
        pane.getChildren().add(Compagnie);
        pane.getChildren().add(VilleDepart);
        pane.getChildren().add(VilleArrivee);
        pane.getChildren().add(DateDepart);
        pane.getChildren().add(DateArrivee);
      
        
        pane.getChildren().add(btn);

        return pane;

    }

    @Override
    public void setScreenPane(StackEcrans screenPage) {
       stackEcrans = screenPage;
    }
}
