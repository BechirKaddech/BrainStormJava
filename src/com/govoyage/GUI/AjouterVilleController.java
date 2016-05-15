/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.ImageDao;
import com.govoyage.DAO.villeDAO;
import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.ville;
import com.govoyage.IDAO.InterfaceScreenController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.govoyage.GUI.StackEcrans;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sirine
 */
public class AjouterVilleController implements Initializable{

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
    private ImageView iv1;
 
//tawa le
        
    public void AjouterVille(ActionEvent event){
        
        ville h = new ville();
        villeDAO hd = new villeDAO();
        ImageM imageM = new ImageM() ;
        ImageDao mediaDao = new ImageDao();
 
        h.setNom(nom.getText());
        h.setPays(pays.getValue().toString());
        h.setLatitude(Double.parseDouble(latitude.getText())); 
        h.setLongitude(Double.parseDouble(longitude.getText()));
        h.setDescription(description.getText());
        
        h.setType(type.getText());
        h.setLangue(langue.getValue().toString());
        
        

       
        //hd.insertVille(h);        
       hd.ajoutervilleimage(imageM, h);
    }
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
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
    public void dashVille(ActionEvent event) throws IOException{
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("VilleDash.fxml"));
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
       
        File file = fileChooser.showOpenDialog(iv1.getScene().getWindow());
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
      iv1.setImage(image);

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
