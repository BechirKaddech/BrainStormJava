/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.ImageDao;
import com.govoyage.DAO.PostDao;
import com.govoyage.DAO.VideoDao;
import com.govoyage.ENTITIES.Post;
import com.govoyage.ENTITIES.User;
import com.govoyage.UTIL.FileHandler;
import com.sun.deploy.uitoolkit.ToolkitStore;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
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
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.StageStyle;

import javax.print.attribute.standard.MediaName;

/**
 *
 * @author user
 */
public class FXMLShowPostController implements Initializable {

    @FXML
    private ListView l1;
    @FXML
    private TextArea t4;
    @FXML
    private TextArea t5;
    @FXML
    private WebView w1;
    @FXML
    private WebEngine e;
    @FXML
    private Button b1;
    @FXML
    private Label l2;
    @FXML
    private ImageView im1;
    @FXML
    private MediaView m1;
    @FXML
    private Button play;
    @FXML
    private Button stop;
    @FXML
    private Button pause;

    @FXML
    private Button full;
    @FXML
    private Button resize;
    @FXML
    private Button del;
    @FXML
    private Label l5;
    @FXML
    private Label luser;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;

    @FXML
    private void handleButtonAction() {

        Post Post = new Post();
        PostDao PostDao = new PostDao();

        ObservableList<Integer> panes = FXCollections.observableArrayList();
        ObservableList<String> panes2 = FXCollections.observableArrayList();
        ArrayList<Post> listPost = new ArrayList<Post>();
        listPost = PostDao.displayAllPosts();
        for (int i = 0; i < listPost.size(); i++) {
            int idhotel = listPost.get(i).getId();
            String nom = listPost.get(i).getTitre();

            // if (listHotel.get(i).getIdHotel()!= idhotel) {
            //panes.add(loadPays(listPays.get(i)));
            System.out.println(idhotel);
            System.out.println(nom);

            panes.add(listPost.get(i).getId());
            panes2.add(listPost.get(i).getTitre());

            l1.setItems(panes2);
        }

    }

    @FXML
    private void handleButtonAction2() {

        Post Post = new Post();
        PostDao PostDao = new PostDao();

        ObservableList<Integer> panes = FXCollections.observableArrayList();
        ObservableList<String> panes2 = FXCollections.observableArrayList();
        ArrayList<Post> listPost = new ArrayList<Post>();
        listPost = PostDao.displayAllPostsByTitle();
        for (int i = 0; i < listPost.size(); i++) {
            int idhotel = listPost.get(i).getId();
            String nom = listPost.get(i).getTitre();

            // if (listHotel.get(i).getIdHotel()!= idhotel) {
            //panes.add(loadPays(listPays.get(i)));
            System.out.println(idhotel);
            System.out.println(nom);

            panes.add(listPost.get(i).getId());
            panes2.add(listPost.get(i).getTitre());

            l1.setItems(panes2);
        }

    }

    @FXML
    private void handleButtonAction3() {

        Post Post = new Post();
        PostDao PostDao = new PostDao();

        ObservableList<Integer> panes = FXCollections.observableArrayList();
        ObservableList<String> panes2 = FXCollections.observableArrayList();
        ArrayList<Post> listPost = new ArrayList<Post>();
        listPost = PostDao.displayAllPostsByDate();
        for (int i = 0; i < listPost.size(); i++) {
            int idhotel = listPost.get(i).getId();
            String nom = listPost.get(i).getTitre();

            // if (listHotel.get(i).getIdHotel()!= idhotel) {
            //panes.add(loadPays(listPays.get(i)));
            System.out.println(idhotel);
            System.out.println(nom);

            panes.add(listPost.get(i).getId());
            panes2.add(listPost.get(i).getTitre());

            l1.setItems(panes2);
        }

    }

    public void ActionM() {
        User user = new User();
        String userlog = user.getName();
        PostDao PostDao = new PostDao();
        Post Post = new Post();
        String titre = (String) l1.getSelectionModel().getSelectedItem();
        String u = PostDao.findPostUser(titre);

        System.out.println(titre);
        int id2;
        id2 = PostDao.findPostByid(titre);
        System.out.println("salem salem ");
        System.out.println(id2);

        Post = PostDao.findPostByTitre(titre);
        int im = PostDao.findPostImage(titre);
        int vi = PostDao.findPostVideo(titre);
        String pai = PostDao.SelectImage(im);
        String pav = PostDao.SelectVideo(vi);

        System.out.println(Post.getTitre());
        l5.setText(Post.getTitre());

        System.out.println(Post.getUser());
        luser.setText(Post.getUser());

        e = w1.getEngine();

        e.loadContent(Post.getContenu());
        String S = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Post.getDate_published());
        l2.setText(S);

        System.out.println("test test image ");
        System.out.println(im);

        System.out.println("test lel path ");
        System.out.println(pai);
//        String url = "E:/uploads/"+pa;
        File f = new File("c:/wamp/www/VersionFinale/web/uploads/" + pai);
        Image image = new Image(f.toURI().toString());
        im1.setImage(image);

        File file = new File("c:/wamp/www/VersionFinale/web/uploads/" + pav);

        String source = file.toURI().toString();

        Media media = new Media(source);

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        m1.setFitHeight(160);
        m1.setFitWidth(300);
        m1.setX(420);
        m1.setY(300);

        System.out.println("hello moro");
        m1.setMediaPlayer(mediaPlayer);

        play.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                mediaPlayer.play();
            }
        });
        pause.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                mediaPlayer.pause();
            }
        });
        stop.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                mediaPlayer.stop();
            }
        });
        full.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                m1.setFitHeight(370);
                m1.setFitWidth(700);
                m1.setX(40);
                m1.setY(0);
            }
        });
        resize.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                m1.setFitHeight(160);
                m1.setFitWidth(300);
                m1.setX(420);
                m1.setY(300);
            }
        });

    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) {

        User user = new User();
        String userlog = user.getName();
        String r = user.getRole();
        PostDao PostDao = new PostDao();
        Post Post = new Post();
        String titre = (String) l1.getSelectionModel().getSelectedItem();
        String u = PostDao.findPostUser(titre);

        if (u.equals(userlog) == true || user.getRole().equals("ROLE_ADMIN")) {
            del.setVisible(true);

            ActionM();

        } else {
            del.setVisible(false);

            ActionM();

        }
    }

    @FXML
    public void del(ActionEvent a) throws FileNotFoundException, IOException {
        String titre = (String) l1.getSelectionModel().getSelectedItem();
        PostDao PostDao = new PostDao();
        VideoDao videoDao = new VideoDao();
        ImageDao imageDao = new ImageDao();
        //supprimer Video
        removeImage();
        removeVideo();
        int iv = PostDao.findPostVideo(titre);
        int im = PostDao.findPostImage(titre);
        videoDao.removeVideoById(iv);
        imageDao.removeImageById(im);

        //supprimer Poste
        int id2;
        id2 = PostDao.findPostByid(titre);
        PostDao.removePostById(id2);
handleButtonAction();
    }

    public void testimage(MouseEvent aff) {
        im1.setFitHeight(600);
    }

    public void removeImage() {
        String titre = (String) l1.getSelectionModel().getSelectedItem();
        PostDao PostDao = new PostDao();
        int im = PostDao.findPostImage(titre);
        String pav = PostDao.SelectImage(im);
        File f = new File("c:/wamp/www/VersionFinale/web/uploads/" + pav);

        f.delete();

    }

    public void removeVideo() {
        String titre = (String) l1.getSelectionModel().getSelectedItem();
        PostDao PostDao = new PostDao();
        int iv = PostDao.findPostVideo(titre);
        String pa = PostDao.SelectVideo(iv);
        System.out.println("c:/wamp/www/VersionFinale/web/uploads/" + pa);
        File file = new File("c:/wamp/www/VersionFinale/web/uploads/" + pa);

        file.deleteOnExit();

    }

    @FXML
    private void ShowI(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAccepterReg.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void ShowIdd(ActionEvent e) throws IOException, Exception {
        System.out.println("quitttttter");

    }

    @FXML
    private void Reclamation(ActionEvent r) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLReclamation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) r.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    public void comment(ActionEvent b) throws IOException {
        Post post = new Post();
        PostDao postDao = new PostDao();

        post = postDao.findPostByTitre((String) l1.getSelectionModel().getSelectedItem());
        FileHandler.saveText("tt", String.valueOf(post.getId()));
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLComment.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) b.getSource()).getScene().getWindow();

        if (l1.getSelectionModel().getSelectedItem() == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLChoosePoste.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        } else {
            app_stage.setScene(home_page_scene);
        }
        app_stage.show();

    }

    public void aljaw(ActionEvent art) {

        {
            System.out.println("fammachay");
        }

    }

    @FXML
    private void Voice(ActionEvent event) {
        Post post = new Post();
        PostDao postDao = new PostDao();
        post = postDao.findPostByTitre((String) l1.getSelectionModel().getSelectedItem());

        System.setProperty("mbrola.base", "C:/Users/user/Desktop/mbrola");
        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice("kevin16");

        voice.allocate();

        voice.speak(post.getTitre());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);

        handleButtonAction();
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
    private void trados(ActionEvent event) throws IOException {
 
      
        Parent par = FXMLLoader.load(getClass().getResource("Traductions.fxml"));
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
