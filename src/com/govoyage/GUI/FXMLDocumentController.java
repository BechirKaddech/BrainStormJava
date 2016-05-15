/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.ImageDao;
import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.User;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;

       @FXML
       private ImageView iv1;
              @FXML
       private DatePicker p1;
               @FXML
               private TextField l1;
                   @FXML
               private TextField l2;
                       @FXML
               private Button btt1;
    
    @FXML
    private void AddI(ActionEvent event) throws IOException {
      Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddPost.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        


    }
        @FXML
    private void ShowI(ActionEvent event) throws IOException {
      Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLShowPost.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        


    }
    

    
         @FXML
    private void login(ActionEvent et) throws IOException {
        User user = new User();
        user.setId(parseInt(l1.getText()));
        user.setName(l2.getText());
        
            System.out.println("Test test");
            System.out.println(user.getName());
  
    }
      @FXML
         private void AddImage(ActionEvent et) throws IOException {
         Stage app_stage = (Stage) ((Node) et.getSource()).getScene().getWindow();
           FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir image...");
    File file= fileChooser.showOpenDialog(iv1.getScene().getWindow());
      Image image = new Image ( file.toURI().toString());
      iv1.setImage(image);
      
      
      String Copystr="";
      String Copystr1="";
      Random randomGenerator = new Random();
       int ran= randomGenerator.nextInt(100);
    
      Copystr1 ="m" + ran  + ".mp4";
               Copystr = ImageM.CURRENT_DIR +"/"+ Copystr1;
                copyFile(file, new File(Copystr));
                
                
                
                System.out.println(Copystr1);
                
                  ImageM Media = new ImageM();
         ImageDao MediaDao = new ImageDao();
   
        Media.setName("test");
         
           Media.setPath(Copystr1);

        MediaDao.addImage(Media);
      
         
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
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ProgressBar p2 = new ProgressBar();
 p2.setProgress(0.25F);
 


 

 
   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));
 
        // TODO
    }    
   
}
