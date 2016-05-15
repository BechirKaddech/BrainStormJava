/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.circuitvipDAO;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.User;
import com.govoyage.ENTITIES.circuitvip;
import com.govoyage.ServiceLocalisation.GeoIPv4;
import com.govoyage.ServiceMeteo.FIOCurrently;
import com.govoyage.ServiceMeteo.ForecastIO;
import com.govoyage.UTIL.FileHandler;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class CircuitaffichedetailleController implements Initializable {
    
    @FXML
    private Label nomcircuit;
    
    @FXML
    private Label dest1;    
    
    @FXML
    private Label dest2;
    
    @FXML
    private Label dest3;    
    
    @FXML
    private Label desc1;    
    
    @FXML
    private Label desc2;
    
    @FXML
    private Label desc3;      
    
    
    @FXML
    private WebView web;

    @FXML
    private ImageView destina1;
    
    @FXML
    private ImageView destina2;

    @FXML
    private ImageView destina3;    
    
    @FXML
    private Label degre1;
   
    @FXML
    private Label degre2;   
    
    @FXML
    private Label degre3;
    
    @FXML
    private ImageView top;
            
    
    
    private static final String apikey = "8be166b11e75f0106e9802fba8b776aa";  



    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        try {
            int idcircuitvip = 0;
            
            if(FileHandler.fileExists("idcircuitvip")){
                idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));
                
                circuitvip cr = new circuitvip();
                circuitvipDAO crdao = new circuitvipDAO();
                villeDAO DAO = new villeDAO();
                
                
                cr = crdao.findcircuitById(idcircuitvip);
                
                
                int im = DAO.findVilleImage(cr.getDestination1().getId());
                String pai = DAO.SelectImage(im);
                File ff = new File("D:/uploads/" + pai);
                Image img = new Image(ff.toURI().toString());
               
                
                
                top.setImage(img);
                nomcircuit.setText(cr.getNomcircuit());
                dest1.setText(cr.getDestination1().getNom());
                dest2.setText(cr.getDestination2().getNom());
                dest3.setText(cr.getDestination3().getNom());
                
                desc1.setText(cr.getDescription1());
                desc2.setText(cr.getDescription2());
                desc3.setText(cr.getDescription2());
            }
            web.getEngine().load(getClass().getResource("googlemap.html").toExternalForm());
            
            getmeteo1();
            getmeteo2();
            getmeteo3();
        } catch (Exception ex) {
            Logger.getLogger(CircuitaffichedetailleController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    @FXML
    public void tracer(ActionEvent event){
        
        int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            circuitvip cr = new circuitvip();
            circuitvipDAO crdao = new circuitvipDAO();

            cr = crdao.findcircuitById(idcircuitvip);  
            
       double latvd=cr.getLatitudevd(); 
       double longvd=cr.getLongitudevd(); 
       double lat1=cr.getLatitude1(); 
       double long1=cr.getLongitude1(); 
       double lat2=cr.getLatitude2(); 
       double long2=cr.getLongitude2();
       double lat3=cr.getLatitude3(); 
       double long3=cr.getLongitude3();        
       web.getEngine().executeScript("initialize("+latvd+","+longvd+","+lat1+","+long1+","+lat2+","+long2+","+lat3+","+long3+")"); 
    } 
    
    
    }
    
    public void getmeteo1() throws Exception{
         
     int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            circuitvip cr = new circuitvip();
            circuitvipDAO crdao = new circuitvipDAO();

            cr = crdao.findcircuitById(idcircuitvip); 
        
        double Lati =cr.getLatitude1();
        String la =String.valueOf(Lati);
        double Long =cr.getLongitude1();
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
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }
               else if("Drizzle".equals(tempo)){
            System.out.println("Clear");
            Image image1 = new Image("/com/govoyage/IMAGES/Drizzle.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }
                       else if("Mostly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }
                               else if("Partly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Partly Cloudy.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }
                                       else if("Light Rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }
                                            else if("rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }   
                                                else if("Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }      
                                                        else if("Breezy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }
                                                                else if("Windy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }                                                  
                                                        else {
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina1.setImage(image1);
            degre1.setText(me+"°C");
        }
     }
        
        
        
    }   
    
    public void getmeteo2() throws Exception{
         
     int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            circuitvip cr = new circuitvip();
            circuitvipDAO crdao = new circuitvipDAO();

            cr = crdao.findcircuitById(idcircuitvip); 
        
        double Lati =cr.getLatitude2();
        String la =String.valueOf(Lati);
        double Long =cr.getLongitude2();
        String lo =String.valueOf(Long);
        
	ForecastIO fio = new ForecastIO(apikey);
	fio.setUnits(ForecastIO.UNITS_SI);
	fio.setLang(ForecastIO.LANG_ENGLISH);
	fio.getForecast(la , lo);
        FIOCurrently currently = new FIOCurrently(fio);
        String [] f  = currently.get().getFieldsArray();
 
                
        System.out.println(currently.get().getByKey(f[8]));

        String me =currently.get().getByKey(f[8]);
        
        String temperature= currently.get().getByKey(f[0]);

        String tempo = temperature.replace("\"","");//pour enlever les guillement
        System.out.println(tempo);

        if("Clear".equals(tempo)){
            System.out.println("Clear");
            Image image1 = new Image("/com/govoyage/IMAGES/Clear.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }
               else if("Drizzle".equals(tempo)){
            System.out.println("Clear");
            Image image1 = new Image("/com/govoyage/IMAGES/Drizzle.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }
                       else if("Mostly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }
                               else if("Partly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Partly Cloudy.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }
                                       else if("Light Rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }
                                            else if("rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }   
                                                else if("Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }      
                                                        else if("Breezy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }
                                                                else if("Windy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }                                                  
                                                        else {
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina2.setImage(image1);
            degre2.setText(me+"°C");
        }
     }
        
        
        
    }
    
    public void getmeteo3() throws Exception{
         
     int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

            circuitvip cr = new circuitvip();
            circuitvipDAO crdao = new circuitvipDAO();

            cr = crdao.findcircuitById(idcircuitvip); 
        
        double Lati =cr.getLatitude3();
        String la =String.valueOf(Lati);
        double Long =cr.getLongitude3();
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
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }
               else if("Drizzle".equals(tempo)){
            System.out.println("Clear");
            Image image1 = new Image("/com/govoyage/IMAGES/Drizzle.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }
                       else if("Mostly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }
                               else if("Partly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Partly Cloudy.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }
                                       else if("Light Rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }
                                            else if("rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }   
                                                else if("Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }      
                                                        else if("Breezy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }
                                                                else if("Windy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }                                                  
                                                        else {
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            destina3.setImage(image1);
            degre3.setText(me+"°C");
        }
     }       
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
     /*   ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/

    }  
    
    
}
