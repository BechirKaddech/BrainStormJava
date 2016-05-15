/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.ImageDao;
import com.govoyage.DAO.PostDao;
import com.govoyage.DAO.VideoDao;
import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.Post;
import com.govoyage.ENTITIES.User;
import com.govoyage.ENTITIES.VideoM;
import static com.sun.deploy.cache.Cache.copyFile;



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 *
 * @author user
 */
public class FXMLAddPosteController implements Initializable {

    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private HTMLEditor t3;
    @FXML
    private ImageView iv1;
        @FXML
    private Label l1;

    private Integer a;

    @FXML

    private void handleButtonAction(ActionEvent event) throws IOException {

        Post Post = new Post();
        PostDao PostDao = new PostDao();
        ImageM imageM = new ImageM() ;
      ImageDao mediaDao = new ImageDao();
              User user = new User();
    String us= user.getName();
           System.out.println(us);
        Post.setTitre(t2.getText());
 
        Post.setContenu(t3.getHtmlText());
Post.setUser(us);
 
        
//        Media Media = new Media();
//        mediaDao.ajouterMedia2(Media, Post);
        mediaDao.ajouterMedia2(imageM, Post);
        l1.setText("Ajouté avec succès!");

    
    

    }

    @FXML
    private void AddImage2(ActionEvent et) throws IOException {
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
        System.out.println("chemain image :   "+ Copystr);
      
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
        @FXML
    private void AddVideo2(ActionEvent ett) throws IOException {
        Stage app_stage = (Stage) ((Node) ett.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir image...");
       
        File file = fileChooser.showOpenDialog(iv1.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
  
          
        String Copystr = "";
        String Copystr1 = "";
        Random randomGenerator = new Random();
        int ran = randomGenerator.nextInt(100);

         Copystr1 ="m" + ran  + ".mp4";
        Copystr = ImageM.CURRENT_DIR + "/" + Copystr1;
        copyFile(file, new File(Copystr));
            
        System.out.println(Copystr1);

        VideoM Media = new VideoM();
         VideoDao MediaDao = new VideoDao();
   
        Media.setName("test");
         
           Media.setPath(Copystr1);

      
      
        Media.setPath(Copystr1);

     MediaDao.addVideo(Media);

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

    @FXML
    private void ShowI(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLShowPost.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    public void setA(Integer a) {
        this.a = a;
    }

    @FXML
    private void Showf(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAccepterReg.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void home(ActionEvent event) throws IOException { 
      
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
    private void Circuit(ActionEvent event) throws IOException {
       
        Parent par = FXMLLoader.load(getClass().getResource("Circuitaffichetout.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }     

}
