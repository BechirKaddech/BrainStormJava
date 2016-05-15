/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;
import com.govoyage.DAO.CommentaireDao;
import com.govoyage.DAO.PostDao;
import com.govoyage.ENTITIES.Commentaire;
import com.govoyage.ENTITIES.Post;
import com.govoyage.ENTITIES.User;
import com.govoyage.UTIL.FileHandler;
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

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author user
 */
public class FXMLShowCommentController implements Initializable {

    @FXML
    private Label l1;
       @FXML
    private Label l4;
     @FXML
    private ListView l3;
         @FXML
    private TextField t1;
   @FXML
    private String name ;
   private Integer poste_id ;
        @FXML
    private Button del;
   @FXML
   
    public void setName(String name) {
   
        System.out.println(name);
        this.name = name;
    }

    public void setPoste_id(Integer poste_id) {
        this.poste_id = poste_id;
    }


    

      public void coo(){
       
        System.out.println("hello there");
        Post Post = new Post();
        PostDao PostDao = new PostDao();
        System.out.println(name);
     
        l1.setText(name);
        Commentaire Commentaire = new Commentaire();
        CommentaireDao CommentaireDao = new CommentaireDao();
        
     
       
       ObservableList<Integer> panes = FXCollections.observableArrayList();
        ObservableList<String> panes2 = FXCollections.observableArrayList();
      
       
       
        ArrayList<Commentaire> listPost = new ArrayList<Commentaire>();
           int idcircuitvip = 0;
            
            if(FileHandler.fileExists("tt")){
                idcircuitvip = Integer.valueOf(FileHandler.getText("tt"));
        listPost = CommentaireDao.findPostById(idcircuitvip);
            }
        for (int i = 0; i < listPost.size(); i++) {
          
            String nom = listPost.get(i).getBody();

            // if (listHotel.get(i).getIdHotel()!= idhotel) {
            //panes.add(loadPays(listPays.get(i)));
          
            System.out.println(nom);

          
            panes2.add(listPost.get(i).getBody());

            l3.setItems(panes2);

    }
    

  


      }
            public void co(ActionEvent a ){
                coo();
            }
       public void add(ActionEvent ab ){
           
               Commentaire commentaire = new Commentaire();
        CommentaireDao commentaireDao = new CommentaireDao();
      int idcircuitvip = 0;
            
            if(FileHandler.fileExists("tt")){
                idcircuitvip = Integer.valueOf(FileHandler.getText("tt"));
            }
        commentaire.setPoste_id(idcircuitvip);
         
           commentaire.setBody(t1.getText());
      User user = new User();
    String us= user.getName();
    commentaire.setUser(us);
        commentaireDao.addPost(commentaire);
        coo();
          
          
       
       
    }
          public void del(ActionEvent ab) throws IOException {
              if( l3.getSelectionModel().getSelectedItem() == null ) 
{
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLChooseComment.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                   stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
    
}
else 
          
                 {
                   
        String titre = (String) l3.getSelectionModel().getSelectedItem();
       CommentaireDao commentaireDao = new CommentaireDao();
              System.out.println("test");
              System.out.println(titre);
       int id_c = commentaireDao.findCommentByid(titre);
        commentaireDao.removeCommentById(id_c);
              coo();
              }
    }
             @FXML
    private void ShowI(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAccepterReg.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
              public void up(ActionEvent abc) throws IOException {
                  if( l3.getSelectionModel().getSelectedItem() == null ) 
{
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLChooseComment.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                   stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
    
}
else 
                  {       
        String titre = (String) l3.getSelectionModel().getSelectedItem();
       CommentaireDao commentaireDao = new CommentaireDao();
       Commentaire commentaire = new Commentaire();
           commentaire.setBody(t1.getText());
           int id_c=commentaireDao.findCommentByid(titre);
       commentaireDao.updateDepot(commentaire, id_c);
              System.out.println("test");
              System.out.println(titre);
              coo();
              
       
    
                  }
    }

      public void testo (MouseEvent ab){
        
           DetectUser();
          
      }
      
 
@FXML
      public void DetectUser () {
                  User user = new User();
              String userlog=  user.getName();
              String r=  user.getRole();
          Commentaire commentaire = new Commentaire();
          CommentaireDao commentaireDao = new CommentaireDao();
            String titre = (String) l3.getSelectionModel().getSelectedItem();
             String u = commentaireDao.findCommentUser(titre);
             System.out.println(u);
                
            
      
             if(u.equals(userlog)==true || user.getRole().equals("ROLE_ADMIN"))
      {
                del.setVisible(true);
      
      
       
}
              else
      {
                del.setVisible(false);
      
      
       
}
          
      }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
    }

}
