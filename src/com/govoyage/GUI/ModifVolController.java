/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.villeDAO;
import com.govoyage.DAO.volDAO;
import com.govoyage.ENTITIES.ville;
import com.govoyage.ENTITIES.vol;
import com.govoyage.IDAO.IvilleDAO;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Date;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author ashref
 */
public class ModifVolController implements Initializable {

    @FXML
    private TextField nomCompagnie;

    @FXML
    private DatePicker dateDepart;

    @FXML
    private DatePicker dateArrivee;

    @FXML
    private TextField nomAeroport;

    @FXML
    private TextField prixVol;

    @FXML
    private ComboBox villeDepart;

    @FXML
    private ComboBox villeArrivee;

    @FXML
    private Button add;

    IvilleDAO ville = new villeDAO();
    ArrayList<ville> listedest = ville.displayAllvilles();

    @FXML
    public void ModifVol(ActionEvent event) {

        int idvol = 0;
        if (FileHandler.fileExists("idvol")) {

            idvol = Integer.valueOf(FileHandler.getText("idvol"));

            vol tv = new vol();
            volDAO tvdao = new volDAO();

            tv = tvdao.findvolById(idvol);

            vol h = new vol();
            volDAO hd = new volDAO();

            h.setNomCompagnie(nomCompagnie.getText());
            h.setVilleDepart(ville.findvilleBynom(villeDepart.getValue().toString()));
            h.setVilleArrivee(ville.findvilleBynom(villeArrivee.getValue().toString()));

            h.setDateDepart(Date.valueOf(dateDepart.getValue()));
            h.setDateArrivee(Date.valueOf(dateArrivee.getValue()));

            h.setNomAeroport(nomAeroport.getText());
            h.setPrixVol((float) Double.parseDouble(prixVol.getText()));
            h.setId(idvol);

            hd.updatevol(h);

        }

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int idvol = 0;
        if (FileHandler.fileExists("idvol")) {
            idvol = Integer.valueOf(FileHandler.getText("idvol"));

            vol vl = new vol();
            volDAO vldao = new volDAO();

            vl = vldao.findvolById(idvol);

            nomCompagnie.setText(vl.getNomCompagnie());
            villeDepart.setValue(vl.getVilleDepart().getNom());
            villeArrivee.setValue(vl.getVilleArrivee().getNom());
            //dateDepart.setValue(Date.valueOf(vl.getDateDepart().getTime()));
           
          //  dateDepart.setValue(LocalDate.MIN);
            //dateArrivee.setText(vl.getDateArrivee());
            //dateArrivee.setValue(LocalDate.MIN);
            nomAeroport.setText(vl.getNomAeroport());

            ObservableList<String> comboVille = FXCollections.observableArrayList();
            ArrayList<ville> listeVille = ville.displayAllvilles();

            for (int i = 0; i < listeVille.size(); i++) {
                comboVille.add(listeVille.get(i).getNom());
            }

            villeDepart.setItems(comboVille);
            villeArrivee.setItems(comboVille);

        }
    }

    @FXML
    public void dasho(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("dashi.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
