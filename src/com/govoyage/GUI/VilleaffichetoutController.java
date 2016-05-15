/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.PostDao;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.User;
import com.govoyage.ENTITIES.ville;
import com.govoyage.ServiceLocalisation.GeoIPv4;
import com.govoyage.ServiceMeteo.FIOCurrently;
import com.govoyage.ServiceMeteo.ForecastIO;
import com.govoyage.UTIL.FileHandler;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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

/**
 * FXML Controller class
 *
 * @author sirine
 */
public class VilleaffichetoutController implements Initializable {
        
    private static final String apikey = "8be166b11e75f0106e9802fba8b776aa";    
    Label meteodep = new Label("35"+"°C");
    Image imgdep = new Image("/com/govoyage/IMAGES/Drizzle.png");
    ImageView imageViewdep = new ImageView(imgdep);

    @FXML
    private ListView showPane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        villeDAO hd = new villeDAO();

        ObservableList<Pane> panes = FXCollections.observableArrayList();
        ArrayList<ville> listville = hd.displayAllvilles();

        for (int i = 0; i < listville.size(); i++) {
                
                panes.add(loadOneHotel(listville.get(i)));

                showPane.setItems(panes);
                showPane.setSelectionModel(null);
            }
        }
      
    private Pane loadOneHotel(ville v) {

        villeDAO DAO = new villeDAO();

        Pane pane = new Pane(); 
        
        int im = DAO.findVilleImage(v.getId());
        String pai = DAO.SelectImage(im);
        File fa = new File("c:/wamp/www/VersionFinale/web/uploads/" + pai);
        Image img = new Image(fa.toURI().toString());
        
        
       
        ImageView imageView = new ImageView(img);//test
        
        Label meteodep = new Label("35"+"°C");
        Image imgdep = null;
        ImageView imageViewdep = new ImageView(imgdep);
        
        // Pane Size
        pane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        pane.setPrefWidth(605);//largeur
        pane.setPrefHeight(164);//hauteur
        pane.setLayoutX(50);
        pane.setLayoutY(200);
        
        String style = "-fx-padding: 18px 0px 14px 0px;\n"
                + "    -fx-background-color: #fff;\n"
                + "    -fx-background-insets: 1px;\n"
                + "    -fx-background-radius: 1px;\n"
                + "    -fx-font-weight: bold;\n"//style interne d'ecriture
                + "    -fx-border-style: solid;\n"//style de la bordure
                + "    -fx-border-width: 1px 0px 1px 0px;\n"//epaiseur de la bordure
                + "    -fx-border-color: rgb(136, 136, 136);\n"//couleur
                + "    -fx-border-insets: -2.2px;\n";//espacement entre les bordure
      
        pane.setStyle(style);
        pane.setId("pane_onePays");
        
        
        // ImageView Proprieties
        imageView.setFitHeight(126);
        imageView.setFitWidth(182);

        imageView.setLayoutX(14);
        imageView.setLayoutY(19);
        
        imageViewdep.setFitHeight(60);
        imageViewdep.setFitWidth(60);
        
        imageViewdep.setLayoutX(510);
        imageViewdep.setLayoutY(38);
     
        
        String styleNom = "\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-border-style: solid;\n"//style de la bordure
                + "    -fx-border-Height: 50;\n"//epaiseur de la bordure
                + "    -fx-border-width: 1px 0px 0px 0px;\n"//epaiseur de la bordure
                + "    -fx-border-color: rgb(230, 230, 230);\n"//couleur                
                + "    -fx-font-weight: bold;\n"
                + "    -fx-text-fill: #444;\n"
                + "    -fx-font-size: 18;";
        
        String stylebuton = "-fx-text-fill: #fff;\n"
                + "    -fx-background-color: #CD9753;\n"
                + "    -fx-background-radius: 0 0 0 0;\n"
                + "    -fx-font:15px Tahoma;\n"
                + "    -fx-background-image: url(\"../IMAGES/direct.png\");\n"//style interne d'ecriture
                + "    -fx-background-repeat: no-repeat;\n"//style de la bordure
                + "    -fx-background-attachment: scroll;\n"//epaiseur de la bordure
                + "    -fx-background-position: 150 11;\n"//couleur
                + "    -fx-background-clip: border-box;\n"//couleur
                + "    -fx-background-origin: padding-box;\n"//couleur
                + "    -fx-background-size: 15px 15px;\n"//couleur
                + "    -fx-border-color:#CD9753;\n";//espacement entre les bordure
        
        String styledest1 = "\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-border-style: solid;\n"//style de la bordure
                + "    -fx-border-Height: 50;\n"//epaiseur de la bordure
                + "    -fx-border-width: 1px 0px 0px 0px;\n"//epaiseur de la bordure
                + "    -fx-border-color: rgb(230, 230, 230);\n"//couleur                
                + "    -fx-font-weight: 300;\n"
                + "    -fx-font-Style: normal;\n"
                + "    -fx-text-fill: #444;\n"
                + "    -fx-font-size: 12;";       
        
        String styledest3 = "\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-border-style: solid;\n"//style de la bordure
                + "    -fx-border-Height: 50;\n"//epaiseur de la bordure
                + "    -fx-border-width: 1px 0px 1px 0px;\n"//epaiseur de la bordure
                + "    -fx-border-color: rgb(230, 230, 230);\n"//couleur                
                + "    -fx-font-weight: 300;\n"
                + "    -fx-font-Style: normal;\n"
                + "    -fx-text-fill: #444;\n"
                + "    -fx-font-size: 12;";
        
        String styledesto = "\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-border-style: solid;\n"//style de la bordure
                + "    -fx-border-Height: 50;\n"//epaiseur de la bordure
                + "    -fx-border-width: 1px 0px 1px 1px;\n"//epaiseur de la bordure
                + "    -fx-border-color: rgb(230, 230, 230);\n"//couleur                
                + "    -fx-font-weight: 300;\n"
                + "    -fx-font-Style: normal;\n"
                + "    -fx-text-fill: #444;\n"
                + "    -fx-font-size: 12;";      
        
        String stylevilledep = "\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-border-style: solid;\n"//style de la bordure
                + "    -fx-border-Height: 50;\n"//epaiseur de la bordure
                + "    -fx-border-width: 1px 1px 1px 1px;\n"//epaiseur de la bordure
                + "    -fx-border-color: rgb(230, 230, 230);\n"//couleur                
                + "    -fx-font-weight: 300;\n"
                + "    -fx-font-Style: normal;\n"
                + "    -fx-text-fill: #444;\n"
                + "    -fx-font-size: 12;"; 
              

        
        
        Label nomville = new Label(v.getNom());
        Label pays = new Label("Pays:\n"+v.getPays());
   
        Button btn = new Button("Detail");

        //Label Proprieties
        nomville.setStyle(styleNom);
        nomville.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        nomville.setPrefHeight(50);// hauteur
        nomville.setPrefWidth(410);// largeur
        nomville.setLayoutX(196);// decalage selon ax des x
        nomville.setLayoutY(19);//decalage selon ax des y
        nomville.setPadding(new Insets(-30, -50, 0, 9));//espacement
        nomville.setId("nonville");
        
        pays.setStyle(styledest1);
        pays.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        pays.setPrefHeight(50);// hauteur
        pays.setPrefWidth(274);// largeur
        pays.setPadding(new Insets(-20, -50, 0, 9));//espacement
        pays.setLayoutX(196);// decalage selon ax des x        
        pays.setLayoutY(63);
        pays.setId("capital");
        
        
        
        
        
     
  
        
        
       
        meteodep.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        meteodep.setPrefHeight(92);// hauteur
        meteodep.setPrefWidth(134);// largeur
        meteodep.setPadding(new Insets(-65, -50, 0, 9));//espacement        
        meteodep.setLayoutX(510);
        meteodep.setLayoutY(85);
        meteodep.setId("meteodep");         
        
        
        
        // Button Position
        btn.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        btn.setPrefHeight(35);
        btn.setPrefWidth(134);
        btn.setStyle(stylebuton);
        btn.setLayoutX(470);
        btn.setLayoutY(110);

        btn.setId("btn_visiter");
        btn.getStyleClass().add("btn-primary");
        
       
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                FileHandler.saveText("idcircuitvip", String.valueOf(v.getId()));
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Villeaffichedetaille.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(CircuitaffichetoutController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        double Lati =v.getLatitude();
        String la =String.valueOf(Lati);
        double Long =v.getLongitude();
        String lo =String.valueOf(Long);
        
	ForecastIO fio = new ForecastIO(apikey);
	fio.setUnits(ForecastIO.UNITS_SI);
	fio.setLang(ForecastIO.LANG_ENGLISH);
	fio.getForecast(la , lo);
        FIOCurrently currently = new FIOCurrently(fio);
        String [] f  = currently.get().getFieldsArray();
 
                
        System.out.println(currently.get().getByKey(f[11]));

        String me =currently.get().getByKey(f[11]);
        
        String temperature= currently.get().getByKey(f[0]);

        String tempo = temperature.replace("\"","");//pour enlever les guillement
        System.out.println(tempo);

        if("Clear".equals(tempo)){
            System.out.println("Clear");
            Image image1 = new Image("/com/govoyage/IMAGES/Clear.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
               else if("Drizzle".equals(tempo)){
            System.out.println("Drizzle");
            Image image1 = new Image("/com/govoyage/IMAGES/Drizzle.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                       else if("Mostly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                               else if("Partly Cloudy".equals(tempo)){
            System.out.println("Partly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Partly Cloudy.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                                       else if("Light Rain".equals(tempo)){
            System.out.println("Light Rain");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                                            else if("rain".equals(tempo)){
            System.out.println("rain");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }   
                                                else if("Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }      
                                                        else if("Breezy and Overcast".equals(tempo)){
            System.out.println("Breezy and Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                                                                else if("Windy and Overcast".equals(tempo)){
            System.out.println("Windy and Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }                                                  
                                                        else {
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        } 
        
        
        pane.getChildren().add(imageViewdep);
        pane.getChildren().add(imageView);
        pane.getChildren().add(nomville);
        pane.getChildren().add(pays);
        pane.getChildren().add(meteodep);
        
        pane.getChildren().add(btn);

        return pane;
    }
        
        
     
    
 
   
       @FXML
    private void recherche(ActionEvent event) throws IOException {

        
        Parent par = FXMLLoader.load(getClass().getResource("RechercherVille.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Acceuil(ActionEvent event) throws IOException {
     
        Parent par = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Circuit(ActionEvent event) throws IOException {
       
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }    
    
    @FXML
    private void Hotel(ActionEvent event) throws IOException {
        
        Parent par = FXMLLoader.load(getClass().getResource("Hotelaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Vol(ActionEvent event) throws IOException {
      
        Parent par = FXMLLoader.load(getClass().getResource("Volaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Ville(ActionEvent event) throws IOException {
        
        Parent par = FXMLLoader.load(getClass().getResource("Villeaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Sejour(ActionEvent event) throws IOException { 
      
        Parent par = FXMLLoader.load(getClass().getResource("Sejouraffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Forum(ActionEvent event) throws IOException { 
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        User user = new User();
        if (user.getName()==null)
        {
           Parent par = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
        }
        else
        {
        Parent par = FXMLLoader.load(getClass().getResource("FXMLRéglement.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }

    }
    
    @FXML
    private void Voiture(ActionEvent event) throws IOException {
  /*
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/

    }     
        	
   
    
}