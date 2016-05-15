/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author user
 */
public class FXMLAccepterReg implements Initializable {

    @FXML
    private WebView w2;
    @FXML
    private WebEngine e;
    @FXML
    private CheckBox c1;
    @FXML
    private MediaView m1;
    File file = new File("C:\\Users\\dell\\Desktop\\javaa\\GOVOYAGE-JAVA\\src\\com\\govoyage\\IMAGES\\reg.mp4");
    String source = file.toURI().toString();
    Media media = new Media(source);
    MediaPlayer mediaPlayer = new MediaPlayer(media);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        m1.setMediaPlayer(mediaPlayer);
        m1.setFitHeight(400);
        m1.setFitWidth(400);
        mediaPlayer.play();

    }

    @FXML
    private void Show(ActionEvent ey) throws IOException {
       
            mediaPlayer.stop();
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLShowPost.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) ey.getSource()).getScene().getWindow();

            app_stage.setScene(home_page_scene);
            app_stage.show();

        } 


    @FXML
    private void Add(ActionEvent e) throws IOException {
      
               mediaPlayer.stop();
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddPost.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            app_stage.setScene(home_page_scene);
            app_stage.show();

        }
    

}
