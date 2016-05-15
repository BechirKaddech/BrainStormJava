/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.ville;
import com.govoyage.ServiceLocalisation.GeoIPv4;
import com.govoyage.ServiceMeteo.FIOCurrently;
import com.govoyage.ServiceMeteo.ForecastIO;
import com.govoyage.UTIL.FileHandler;
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
import javafx.scene.control.TextField;
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
public class RechercherVilleController implements Initializable {
        
    private static final String apikey = "8be166b11e75f0106e9802fba8b776aa";    
    Label meteodep = new Label("35"+"°C");
    Image imgdep = new Image("/com/govoyage/IMAGES/Drizzle.png");
    ImageView imageViewdep = new ImageView(imgdep);

    @FXML
    private ListView showPane;
      @FXML
    private TextField rech;
    
    @FXML
    private Button add;
    

    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        }
      
       @FXML
    public void action(){
       String h;
       h=rech.getText();
       sir(h) ;
        
    }
    
    
     public void sir(String h){
         
        villeDAO ville = new villeDAO();

        ObservableList<Pane> pane = FXCollections.observableArrayList();
        ville listecircuit = ville.findvilleBynom(h);
     
       
                pane.add(getPaysInPane(listecircuit));
        
                showPane.setItems(pane);
                showPane.setSelectionModel(null);
           
    }
  
     
    
  public void getmeteo() throws Exception{
        
        String ipadress = findIP("http://www.monip.org/","<BR>IP : ","<br>");
        
        System.out.println(GeoIPv4.getLocation(ipadress).getLatitude());  
        System.out.println(GeoIPv4.getLocation(ipadress).getLongitude());        
        
        float Lati =(GeoIPv4.getLocation(ipadress).getLatitude());
        String la =String.valueOf(Lati);
        float Long =GeoIPv4.getLocation(ipadress).getLongitude();
        String lo =String.valueOf(Long);
        
	ForecastIO fio = new ForecastIO(apikey);
	fio.setUnits(ForecastIO.UNITS_SI);
	fio.setLang(ForecastIO.LANG_ENGLISH);
	fio.getForecast(la , lo);
        FIOCurrently currently = new FIOCurrently(fio);
        String [] f  = currently.get().getFieldsArray();
 
                
        System.out.println(currently.get().getByKey(f[10]));

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
            System.out.println("Clear");
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
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Partly Cloudy.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                                       else if("Light Rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                                            else if("rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
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
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            imageViewdep.setImage(image1);
            meteodep.setText(me+"°C");
        }
                                                                else if("Windy and Overcast".equals(tempo)){
            System.out.println("Overcast");
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
        
        
        
    }   
  
   public String findIP(String site, String prefixe, String suffixe) throws Exception 
    {         
        Scanner sc = new Scanner(new URL(site).openStream()); 
         
        while (sc.hasNextLine()) 
        { 
            String line = sc.nextLine(); 
             
            int a = line.indexOf(prefixe); 
            if (a!=-1) 
            { 
                int b = line.indexOf(suffixe,a); 
                if (b!=-1) 
                { 
                    sc.close(); 
                    return line.substring(a+prefixe.length(),b); 
                } 
            } 
        } 
         
        sc.close(); 
        return null; 
    }     
        public Pane getPaysInPane(ville c) {
         
        villeDAO ville = new villeDAO();
        Pane pane = new Pane();

        Label nomPays = new Label("Nom : " + c.getNom());
        nomPays.setLayoutX(5);
        nomPays.setLayoutY(5);

        Label capitalePays = new Label("Pays : " + c.getPays());
        capitalePays.setLayoutX(300);
        capitalePays.setLayoutY(5);

        Label languePays = new Label("latitude: " + c.getLatitude());
        languePays.setLayoutX(600);
        languePays.setLayoutY(5);
        
        Label lat = new Label("longitude : " + c.getLongitude());
        lat.setLayoutX(900);
        lat.setLayoutY(5);
        
        Label lon = new Label("Description: " + c.getDescription());
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

        
        pane.getChildren().addAll(nomPays, capitalePays,languePays,lat ,lon,remove, modif);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 5px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
    }
        
      @FXML
    public void retour(ActionEvent event) throws IOException{
     
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Villeaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
          @FXML
    public void accueil(ActionEvent event) throws IOException{
     
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
   
    
}
