/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;


import com.govoyage.DAO.HotelDAO;
import com.govoyage.ENTITIES.Hotel;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Firasss
 */
public class ShowRemoveUpdate extends Application{
    
    List<Hotel> list;
    TableView<Hotel> table = new TableView<>();
    
    public static void main(String[] args) {
	Application.launch(ShowRemoveUpdate.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox v = new VBox(20);
        Scene sc = new Scene(v,900,600);
        
        
        
        
        
        Callback<TableColumn<Hotel, Object>, TableCell<Hotel, Object>> cellFactory = (
		        TableColumn<Hotel, Object> p) -> new EditingCell();
		
		        
			    table.setEditable(true);
                            
            HBox h = new HBox(20);
	    TextField tt = new TextField();
	    tt.setFocusTraversable(false);
            tt.setPromptText("Name");
	    tt.getStyleClass().add("button-search");
	    
	    tt.setOnKeyReleased(e ->{
	    	if(tt.getText().equals(""))
	    		table.setItems(getDoctor());
	    	else table.setItems(getDoctor2(tt.getText()));
	    });
	    tt.setMinHeight(35);
	    
	    TableColumn<Hotel,Object> firstNameCol = new TableColumn("Nom");
	    firstNameCol.setMinWidth(80);
	    firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("nomHotel"));
	    
	    firstNameCol.setCellFactory(cellFactory);
	    firstNameCol.setOnEditCommit((CellEditEvent<Hotel, Object> t) -> {
	      ((Hotel) t.getTableView().getItems().get(t.getTablePosition().getRow()))
	          .setNomHotel((String) t.getNewValue());
	    });
	    
	    TableColumn <Hotel,Object> lastNameCol = new TableColumn("Catégorie");
	    lastNameCol.setMinWidth(100);
	    lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("Categorie"));
	    
	    lastNameCol.setCellFactory(cellFactory);
	    lastNameCol.setOnEditCommit((CellEditEvent<Hotel, Object> t) -> {
	      ((Hotel) t.getTableView().getItems().get(t.getTablePosition().getRow()))
	          .setCategorie((String) t.getNewValue());
	    });
	    
	    TableColumn<Hotel,Object> loginCol = new TableColumn("Disponibilité");
	    loginCol.setMinWidth(140);
	    loginCol.setCellValueFactory(
                new PropertyValueFactory<>("Disponibilite"));
	    
	    loginCol.setCellFactory(cellFactory);
	    loginCol.setOnEditCommit((CellEditEvent<Hotel, Object> t) -> {
	      ((Hotel) t.getTableView().getItems().get(t.getTablePosition().getRow()))
	          .setDisponibilite((String) t.getNewValue());
	    });
	    
	    TableColumn<Hotel,Object> passwordCol = new TableColumn("Description");
	    passwordCol.setMinWidth(120);
	    passwordCol.setCellValueFactory(
                new PropertyValueFactory<>("Description"));
	    
	    passwordCol.setCellFactory(cellFactory);
	    passwordCol.setOnEditCommit((CellEditEvent<Hotel, Object> t) -> {
	      ((Hotel) t.getTableView().getItems().get(t.getTablePosition().getRow()))
	          .setDescription((String) t.getNewValue());
	    });
	    
	    
	    table.getColumns().addAll(firstNameCol, lastNameCol, loginCol,passwordCol);
	    table.setMaxSize(800, 200);
	    table.setItems(getDoctor());
	    Button remove = new Button("Remove");
            remove.getStyleClass().add("button-remove");
            remove.setMinWidth(200);
            remove.setOnAction(e ->{
                HotelDAO hd = new HotelDAO();
                hd.SupprimerHotel(table.getSelectionModel().getSelectedItem().getId());
                table.setItems(getDoctor());
            });
	    Button update = new Button("Update");
	    update.setOnAction(e ->{
		HotelDAO hd = new HotelDAO();
                hd.ModifierHotel(list.get(table.getSelectionModel().getSelectedIndex()));
                table.setItems(getDoctor());
	    });
	    update.setMinWidth(200);
	    update.getStyleClass().add("button-save");
	    
	    Button retour = new Button("Back");
	    retour.setMinWidth(300);
	    retour.getStyleClass().add("button-back");
            retour.setOnAction(e ->{
                Ajout a = new Ajout();
                stage.hide();
            try {
                a.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ShowRemoveUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
	    h.getChildren().addAll(update,remove);
	    v.getChildren().addAll(tt,table,h,retour);
	    v.setAlignment(Pos.CENTER);
            v.setFillWidth(false);       
                            
        
        sc.getStylesheets().add("Ressources/JavaFX.css");
        stage.setScene(sc);
        v.setAlignment(Pos.CENTER);
        v.setFillWidth(false);
        stage.show();
    }
    
    
    
    public ObservableList<Hotel> getDoctor(){
        HotelDAO hd = new HotelDAO();
	list = hd.AfficherHotel();
    	ObservableList<Hotel> doctors = FXCollections.observableArrayList();
    	for (int i=0;i<list.size();i++)
    		doctors.add(list.get(i));
    	return doctors;
    }
    
    public ObservableList<Hotel> getDoctor2(String nom){
        HotelDAO hd = new HotelDAO();
	list = hd.ChercherHotel2(nom);
    	ObservableList<Hotel> doctors = FXCollections.observableArrayList();
    	for (int i=0;i<list.size();i++)
    		doctors.add(list.get(i));
    	return doctors;
    }
    
    
    class EditingCell extends TableCell<Hotel, Object> {
	    private TextField textField;
	    public EditingCell() {
	    }

	    @Override
	    public void startEdit() {
	      if (!isEmpty()) {
	        super.startEdit();
	        createTextField();
	        setText(null);
	        setGraphic(textField);
	        textField.selectAll();
	      }
	    }

	    @Override
	    public void cancelEdit() {
	      super.cancelEdit();
	      setText((String) getItem());
	      setGraphic(null);
	    }

	    @Override
	    public void updateItem(Object item, boolean empty) {
	      super.updateItem(item, empty);
	      if (empty) {
	        setText(null);
	        setGraphic(null);
	      } else {
	        if (isEditing()) {
	          if (textField != null) {
	            textField.setText(getString());
	          }
	          setText(null);
	          setGraphic(textField);
	        } else {
	          setText(getString());
	          setGraphic(null);
	        }
	      }
	    }

	    private void createTextField() {
	      textField = new TextField(getString());
	      textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
	      textField.focusedProperty()
	          .addListener(
	              (ObservableValue<? extends Boolean> arg0, Boolean arg1,
	                  Boolean arg2) -> {
	                if (!arg2) {
	                  commitEdit(textField.getText());
	                }
	              });
	    }

	    private String getString() {
	      return getItem() == null ? "" : getItem().toString();
	    }
	  }
    
}
