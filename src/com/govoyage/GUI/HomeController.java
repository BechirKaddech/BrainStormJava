/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.ENTITIES.User;
import com.govoyage.IDAO.InterfaceScreenController;
import com.govoyage.ServiceLocalisation.GeoIPv4;
import com.govoyage.ServiceMeteo.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class HomeController implements Initializable,InterfaceScreenController {
    
    private static final String apikey = "8be166b11e75f0106e9802fba8b776aa";
        private static final String apikeyT="3QFmgKikILW8BQBixgS2zEe17";
    private StackEcrans stackEcrans;
    
    
    @FXML
    private ImageView meteo;
    
    @FXML
    private Label timerLabel;
 
    @FXML
    private Label degre;    

    @FXML
    private MediaView video;
    
    @FXML
    private Button song;
    
    @FXML
    private Button contact;    
    
    @FXML
    private TextField chamnews;    
    
    public Timer timer = new Timer();

    public int i=1;
   
        final File file = new File("C:\\Users\\dell\\Desktop\\javaa\\GOVOYAGE-JAVA\\src\\com\\govoyage\\IMAGES\\paris.mp4"); 
        final Media media = new Media(file.toURI().toString()); 
        final MediaPlayer mediaPlayer = new MediaPlayer(media);         
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
           // chamnews.setPromptText("Votre e-mail");
            play();
            Refresh();
           
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
        	
   
    
    public void getmeteo() throws Exception{
        
        String ipadress =findIP("http://www.monip.org/","<BR>IP : ","<br>");
        
        //System.out.println(GeoIPv4.getLocation(ipadress).getLatitude());  
       // System.out.println(GeoIPv4.getLocation(ipadress).getLongitude());        
        
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
 
                
        //System.out.println(currently.get().getByKey(f[6]));

        String me =currently.get().getByKey(f[6]);
        
        String temperature= currently.get().getByKey(f[0]);

        String tempo = temperature.replace("\"","");//pour enlever les guillement
        System.out.println(tempo);

        if("Clear".equals(tempo)){
            System.out.println("Clear");
            Image image1 = new Image("/com/govoyage/IMAGES/Clear.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }
               else if("Drizzle".equals(tempo)){
            System.out.println("Clear");
            Image image1 = new Image("/com/govoyage/IMAGES/Drizzle.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }
                       else if("Mostly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }
                               else if("Partly Cloudy".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Partly Cloudy.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }
                                       else if("Light Rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }
                                            else if("rain".equals(tempo)){
            System.out.println("Mostly Cloudy");
            Image image1 = new Image("/com/govoyage/IMAGES/Light Rain.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }   
                                                else if("Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }      
                                                        else if("Breezy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }
                                                                else if("Windy and Overcast".equals(tempo)){
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Breezy and Overcast.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }                                                  
                                                        else {
            System.out.println("Overcast");
            Image image1 = new Image("/com/govoyage/IMAGES/Mostly Cloudy.png", true);
            meteo.setImage(image1);
            degre.setText(me+"°C");
        }
        
        
        
    }
    
    public void play(){

        video.setMediaPlayer(mediaPlayer);
        mediaPlayer.play(); 
        mediaPlayer.setCycleCount(100);        
    }
      
    public void heureactu(){
        
       /* timeSeconds.set(cal.get(Calendar.SECOND));
        timerLabel.textProperty().bind(timeSeconds.asString());*/
      //String hedi =String.valueOf(new Date());
        
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("HH:mm");  
        timerLabel.setText(ft.format(dNow));
   
    }
       
    public void Refresh(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            heureactu();
                            getmeteo();
                        } catch (Exception ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        }, 0, 50000);        
    }

    @FXML
    public void test(ActionEvent event){

    if(i==1){       
                song.setStyle(
            "    -fx-background-image: url(\"/com/govoyage/IMAGES/Mute.png\");\n" +
            "    -fx-background-repeat: no-repeat;\n" +
            "    -fx-background-attachment: scroll;\n" +
            "    -fx-background-position: right bottom;\n" +
            "    -fx-background-clip: border-box;\n" +
            "    -fx-background-origin: padding-box;\n" +
            "    -fx-background-size: 30px 30px;  ");
    i=0;       
      
        mediaPlayer.setMute(true);
        
       
    }
    else
    {       
                song.setStyle(
            "    -fx-background-image: url(\"/com/govoyage/IMAGES/songg.png\");\n" +
            "    -fx-background-repeat: no-repeat;\n" +
            "    -fx-background-attachment: scroll;\n" +
            "    -fx-background-position: right bottom;\n" +
            "    -fx-background-clip: border-box;\n" +
            "    -fx-background-origin: padding-box;\n" +
            "    -fx-background-size: 30px 30px;  ");
    i=1;            
      
        mediaPlayer.setMute(false);
    }    
 
  }  
    
    @FXML
    private void Circuit(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
       
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Hotel(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
     
        Parent par = FXMLLoader.load(getClass().getResource("Hotelaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Vol(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
      
        Parent par = FXMLLoader.load(getClass().getResource("Volaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Ville(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
       
        Parent par = FXMLLoader.load(getClass().getResource("Villeaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Sejour(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
        
        Parent par = FXMLLoader.load(getClass().getResource("Sejouraffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
   //ok 
    @FXML
    private void Forum(ActionEvent event) throws IOException {
      timer.cancel();
        mediaPlayer.stop(); 
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
      /*  timer.cancel();
        mediaPlayer.stop(); 
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/

    }
    
    @FXML
    private void contact(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
     
        Parent par = FXMLLoader.load(getClass().getResource("Mail.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }   
    
    @FXML
    private void trados(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
      
        Parent par = FXMLLoader.load(getClass().getResource("Traductions.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }   
    
    @FXML
    private void inscription(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
     
        Parent par = FXMLLoader.load(getClass().getResource("Inscriptionutil.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }  
    
        
    @FXML
    private void SMS(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
    
        Parent par = FXMLLoader.load(getClass().getResource("feedbackSMS.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
      
        Parent par = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }     
      @FXML
    private void MonCompte(ActionEvent event) throws IOException {
        timer.cancel();
        mediaPlayer.stop(); 
      
        Parent par = FXMLLoader.load(getClass().getResource("AffichageCompte.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }  
    
    @FXML
    public void Partager()
    {
         ConfigurationBuilder cf = new ConfigurationBuilder();
        BasicConfigurator.configure();
        cf.setDebugEnabled(true)
        
           .setOAuthConsumerKey("3QFmgKikILW8BQBixgS2zEe17")
           .setOAuthConsumerSecret("QoAzVxo9YjouYbOSXMjjLNtTWqpRUlFmBDAHvsjKFk37XZSBy1")
           .setOAuthAccessToken("731124800043790336-S5A6P30gAxykUJ9cNCxJOQg15WVBUhH")
           .setOAuthAccessTokenSecret("PYqIt955kBuKOly3WptQtJBPKVoqyLvcASUzOoDcLywT5");
        
        TwitterFactory tf = new TwitterFactory(cf.build());
        twitter4j.Twitter twitter = tf.getInstance();
        //Status stat;
        try {
            // twitter4j.Status status = twitter.updateStatus(apikeyT);
             twitter4j.Status  stat =twitter.updateStatus("ashrefhttps://www.facebook.com/GoVoyage-1529268744025567/?fref=ts");
            //return "Tweet ajouté";
            //System.out.println("twitter updated");
        } catch (TwitterException ex) {
            ex.printStackTrace();
            //return "Tweet non ajouté";
        }
        
        
    }   
    
        @Override
    public void setScreenPane(StackEcrans screenPage) {
          stackEcrans = screenPage;
    }
    
    
    
    
}
