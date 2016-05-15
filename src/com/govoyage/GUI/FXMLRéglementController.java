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
public class FXMLRéglementController implements Initializable {

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

        e = w2.getEngine();

        e.loadContent("<h3 style=\"color: red; text-align: center;\">\n"
                + "	CHARTE DU FORUM</h3>\n"
                + "<div>\n"
                + "	<span style=\"color:#ff8c00;\"><strong>Article 1:</strong></span> <span style=\"color:#b22222;\">Le respect de toutes les personnes est primordial</span> pour bien &eacute;voluer au sein du forum. Aucune insulte, moquerie en tout genre n&#39;est donc tol&eacute;r&eacute;e, sous toutes les formes (M&ecirc;me pas sous forme de ***).</div>\n"
                + "<div>\n"
                + "	&nbsp;</div>\n"
                + "<div>\n"
                + "	<strong style=\"color: rgb(255, 140, 0);\">Article 2:</strong>&nbsp;Tout <span style=\"color:#b22222;\">propos</span> injurieux, violents, diffamatoires, raciste, x&eacute;nophobe, p&eacute;dophiles, pornographiques est interdit:</div>\n"
                + "<div>\n"
                + "	&nbsp;</div>\n"
                + "<div>\n"
                + "	<strong style=\"color: rgb(255, 140, 0);\">Article 3:</strong>&nbsp;Les propos portant sur des <span style=\"color:#b22222;\">sujets instables</span> comme la politique, la religion ou autres sont &agrave; &eacute;viter.</div>\n"
                + "<div>\n"
                + "	&nbsp;</div>\n"
                + "<div>\n"
                + "	<strong style=\"color: rgb(255, 140, 0);\">Article 4:</strong>&nbsp;Le double poste <span style=\"color:#b22222;\">est interdit</span>.</div>\n"
                + "<div>\n"
                + "	&nbsp;</div>\n"
                + "<div>\n"
                + "	<strong style=\"color: rgb(255, 140, 0);\">Article 5:</strong>&nbsp; <span style=\"color:#b22222;\">Attention &agrave; votre &eacute;criture</span>. Vous devez &eacute;crire un fran&ccedil;ais compr&eacute;hensible, on ne vous demande pas des phrases irr&eacute;prochables, mais faites un effort! Le langage sms est donc &agrave; proscrire. Les messages &eacute;crits partiellement ou enti&egrave;rement en majuscule sont aussi &agrave; proscrire pour le confort de tous. (Que ce soit pour un titre, message ou toutes autres formes &eacute;crites sur le forum).</div>\n"
                + "<div>\n"
                + "	&nbsp;</div>\n"
                + "<div>\n"
                + "	<span style=\"color:#ff8c00;\"><strong>Article 6:</strong></span> <span style=\"color:#b22222;\">Pub et spam sont interdits</span> sur le forum! Vous pouvez mettre un lien sur votre profil mais rien de plus. Pas de pub non plus dans les signatures.</div>\n"
                + "<div>\n"
                + "	&nbsp;</div>\n"
                + "<div>\n"
                + "	<strong><span style=\"color:#ff8c00;\">Article 7:</span></strong> <span style=\"color:#b22222;\">Seul le staff est autoris&eacute;</span> &agrave; dire si oui ou non une personne enfreins le r&egrave;glement. Toutes autres personnes se permettant de porter un jugement semblable et ne faisant pas partie du staff sera consid&eacute;r&eacute; lui aussi comme fautif. (Si vous d&eacute;sirez aider le staff alors envoyez un message priv&eacute; &agrave; l&#39;un d&#39;eux pour les pr&eacute;venir)</div>\n"
                + "<div>\n"
                + "	&nbsp;</div>\n"
                + "<div>\n"
                + "	<strong><span style=\"color:#ff8c00;\">Article 8:</span></strong> Le r&egrave;glement est susceptible de changer &agrave; tout instant, vous &ecirc;tes donc tenu de vous <span style=\"color:#b22222;\">informer des changements.</span></div>");

        m1.setMediaPlayer(mediaPlayer);
        m1.setFitHeight(400);
        m1.setFitWidth(400);
        mediaPlayer.play();

    }

    @FXML
    private void Show(ActionEvent ey) throws IOException {
        if (c1.isSelected() == true) {
            mediaPlayer.stop();
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLShowPost.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) ey.getSource()).getScene().getWindow();

            app_stage.setScene(home_page_scene);
            app_stage.show();

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLCheckBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        }
    }

    @FXML
    private void Add(ActionEvent e) throws IOException {
        if (c1.isSelected() == true) {
               mediaPlayer.stop();
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddPost.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            app_stage.setScene(home_page_scene);
            app_stage.show();

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLCheckBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        }
    }

}
