/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.PostDao;
import com.govoyage.DAO.ReclamationDao;
import com.govoyage.DAO.volDAO;
import com.govoyage.ENTITIES.Post;
import com.govoyage.ENTITIES.Reclamation;
import com.govoyage.ENTITIES.User;
import com.govoyage.ENTITIES.vol;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class FXMLAdminReclamationController implements Initializable {
    @FXML
    private ListView l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
      @FXML
    private Label l5;
          @FXML
    private ImageView i1;
             @FXML
    private ListView showPane;
   
     @FXML
    private void handleButtonAction() {
         Reclamation reclamation=new Reclamation() ; 
         ReclamationDao reclamationDao = new ReclamationDao();

        ObservableList<Integer> panes = FXCollections.observableArrayList();
        ObservableList<String> panes2 = FXCollections.observableArrayList();
        ArrayList<Reclamation> listReclamation= new ArrayList<Reclamation>();
        listReclamation = reclamationDao.displayAllReclamation();
        for (int i = 0; i < listReclamation.size(); i++) {
            int idhotel = listReclamation.get(i).getId();
            String nom = listReclamation.get(i).getTitre();

            // if (listHotel.get(i).getIdHotel()!= idhotel) {
            //panes.add(loadPays(listPays.get(i)));
            System.out.println(idhotel);
            System.out.println(nom);

            panes.add(listReclamation.get(i).getId());
            panes2.add(listReclamation.get(i).getTitre());

            l1.setItems(panes2);
        }
          
            

    }
       @FXML
       public void ShowReclamation (MouseEvent arg0){
           
           Reclamation reclamation = new Reclamation();
           ReclamationDao reclamationDao= new ReclamationDao();
             String titre = (String) l1.getSelectionModel().getSelectedItem();
           reclamation=reclamationDao.findReclamtionByTitre(titre);
              String S = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(reclamation.getDate_published());
      
                        
         
              reclamation=reclamationDao.findReclamtionByTitre(titre);
             EtatReclamation();
           l2.setText("Sujet: "+reclamation.getTitre());
           l3.setText(reclamation.getContenu());
           l4.setText(reclamation.getEtat());
          l5.setText("Réclamé le: "+S);

      
             
              System.out.println("done");
               }
         
       
     
       
       public void EtatReclamation(){
     Reclamation reclamation = new Reclamation();
           ReclamationDao reclamationDao= new ReclamationDao();
             String titre = (String) l1.getSelectionModel().getSelectedItem();
           reclamation=reclamationDao.findReclamtionByTitre(titre);
           String etat = reclamation.getEtat();
           if ("Validé".equals(reclamation.getEtat()))
           {
                Image img = new Image("/com/govoyage/IMAGES/okk.png");
        i1.setImage(img);
           }
            else  if ("Non Validé".equals(reclamation.getEtat()))
           {
              Image img = new Image("/com/govoyage/IMAGES/notok.png");
        i1.setImage(img);
           }
              else  if ("En cours".equals(reclamation.getEtat()))
           {
              Image img = new Image("/com/govoyage/IMAGES/encours.png");
        i1.setImage(img);
           }
}
           @FXML
           public void validerReclamation (ActionEvent e){
               Reclamation reclamation = new Reclamation();
               ReclamationDao reclamationDao = new ReclamationDao();
                 String titre = (String) l1.getSelectionModel().getSelectedItem();
               int id = reclamationDao.findReclamationByid(titre);
             reclamationDao.ValiderRec(id);
             handleButtonAction();
               
           }
           @FXML
           public void removeR(ActionEvent e){
               Reclamation reclamation = new Reclamation();
               ReclamationDao reclamationDao = new ReclamationDao();
                   String titre = (String) l1.getSelectionModel().getSelectedItem();
               int id = reclamationDao.findReclamationByid(titre);
               reclamationDao.removeReclamationId(id);
               handleButtonAction();
           }
                @FXML
           public void EnCoursReclamation (ActionEvent e){
               Reclamation reclamation = new Reclamation();
               ReclamationDao reclamationDao = new ReclamationDao();
                 String titre = (String) l1.getSelectionModel().getSelectedItem();
               int id = reclamationDao.findReclamationByid(titre);
             reclamationDao.EnCoursRec(id);
             handleButtonAction();
                   
          
           }
           
             @FXML
    private void ShowD(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("dashi.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
    
    @FXML
    private void ShowI(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAccepterReg.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
                           User user = new User();
                           System.out.println("test user :"+ user.getName());
                           System.out.println("test user :"+ user.getRole());

        handleButtonAction();
    }
}
    