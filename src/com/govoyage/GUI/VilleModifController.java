/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.ImageDao;
import com.govoyage.DAO.circuitvipDAO;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.circuitvip;
import com.govoyage.ENTITIES.ville;
import com.govoyage.UTIL.FileHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sirine
 */
public class VilleModifController implements Initializable {
        @FXML
    private TextField nom; 
    
    @FXML
    private ComboBox pays;
    
    @FXML
    private TextField latitude;
    
    @FXML
    private TextField longitude;
    
    @FXML
    private TextArea description;
    
    @FXML
    private TextField type;
    
    @FXML
    private ComboBox langue;
    
    @FXML
    private Button add;
    @FXML
    private ImageView imag; 
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));
                ville c = new ville();
                villeDAO ville = new villeDAO();
                c = ville.findvilleById(idcircuitvip); 
                
                nom.setText(c.getNom());
                pays.setValue(c.getPays());
                latitude.setText(String.valueOf(c.getLatitude()));
                longitude.setText(String.valueOf(c.getLongitude()));
                description.setText(c.getDescription());
                type.setText(c.getType());
                langue.setValue(c.getLangue());
                
       
        

           
        
                
        int im = ville.findVilleImage(c.getId());
        String pai = ville.SelectImage(im);
        File f = new File("c:/wamp/www/VersionFinale/web/uploads/" + pai);
        Image img = new Image(f.toURI().toString());
         imag.setImage(img);
                
                
                
                 ObservableList<String> sirina = FXCollections.<String>observableArrayList();
        sirina.add("France");
        sirina.add("Tunisie");
        sirina.add("Allemagne");
        sirina.add("Dubai");
        sirina.add("Italie");
        sirina.add("Espagne");
        sirina.add("Algerie");
        sirina.add("Australie");
        sirina.add("Belgique");
        sirina.add("Maroc");
        sirina.add("Chine");
        sirina.add("Irlande");
        sirina.add("Japon");
        sirina.add("Mexique");
        sirina.add("Portugal");
        sirina.add("Espagne");
        sirina.add("Suède");
        sirina.add("Suisse");
        sirina.add("Turquie");
        sirina.add("Thaïlande");
        
        pays.setItems(sirina);
        
        ObservableList<String> sirina2 = FXCollections.<String>observableArrayList();
        sirina2.add("Arabe");
        sirina2.add("Français");
        sirina2.add("Allemand");
        sirina2.add("brésilien");
        sirina2.add("Turc");
        sirina2.add("Chinois");
        sirina2.add("Coreen");
        sirina2.add("Hindi");
        sirina2.add("Roumain");
        sirina2.add("Italien");
         sirina2.add("Anglais");
        
        langue.setItems(sirina2);

     }
    }

        @FXML
    public void update(ActionEvent event) throws IOException{
        
     int idcircuitvip = 0;
        
     if(FileHandler.fileExists("idcircuitvip")){   
            idcircuitvip = Integer.valueOf(FileHandler.getText("idcircuitvip"));

          

              ville c1 = new ville();
                villeDAO villee = new villeDAO();
                 c1 = villee.findvilleById(idcircuitvip);
                 
                 ville c = new ville();
                villeDAO ville = new villeDAO();
                
                    ImageM imageM = new ImageM() ;
                  ImageDao mediaDao = new ImageDao();
                     
 
                 
        c.setNom(nom.getText());
        
        c.setPays(pays.getValue().toString());
        
        c.setLatitude(Double.parseDouble(latitude.getText()));

        c.setLongitude(Double.parseDouble(longitude.getText()));
        c.setDescription(description.getText());
         c.setType(type.getText());
        c.setLangue(langue.getValue().toString());
           c.setType(type.getText());
           villee.ajoutervilleimage(imageM, c);

          
        
        
      
        
            
        c.setId(c1.getId());
         
     
      if (ville.updateVille(c)) {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("VilleDash.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

                }
        
    }}


     
    @FXML
    public void dashville(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("VilleDash.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    @FXML
    public void dash(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("dashi.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
        @FXML
    private void AJOUTERIMAGE(ActionEvent et) throws IOException {
        Stage app_stage = (Stage) ((Node) et.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir image...");
       
        File file = fileChooser.showOpenDialog(imag.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
       

        String Copystr = "";
        String Copystr1 = "";
        Random randomGenerator = new Random();
        int ran = randomGenerator.nextInt(100);

         Copystr1 ="m" + ran  + ".jpeg";
        Copystr = ImageM.CURRENT_DIR + "/" + Copystr1;
        copyFile(file, new File(Copystr));

        System.out.println(Copystr1);

          ImageM Media = new ImageM();
         ImageDao MediaDao = new ImageDao();
   
        Media.setName("test");
         
           Media.setPath(Copystr1);

      
   
        Media.setPath(Copystr1);

     MediaDao.addImage(Media);
      imag.setImage(image);

    }
    
        private void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();

            // previous code: destination.transferFrom(source, 0, source.size());
            // to avoid infinite loops, should be:
            long count = 0;
            long size = source.size();
            while ((count += destination.transferFrom(source, count, size
                    - count)) < size)
                ;
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }
    
}



        // TO   
    

