/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.GUI;

import com.govoyage.DAO.HotelDAO;
import com.govoyage.DAO.circuitvipDAO;
import com.govoyage.DAO.sejourDAO;
import com.govoyage.DAO.villeDAO;
import com.govoyage.DAO.volDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class DashiController implements Initializable {
    

    @FXML
    private MenuItem showStats;
    
    @FXML
    private ListView showPane;
    
    @FXML
    private MenuItem showStat2;
    
    @FXML
    private ListView showPanee;
    ObservableList<PieChart.Data> contentData;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
        @FXML
    private void Acceuil(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    public void circuit(ActionEvent event) throws IOException{
     
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("CircuitDash.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }    
    
    @FXML
    private void Hotel(ActionEvent event) throws IOException, Exception {
        ShowRemoveUpdate s = new ShowRemoveUpdate();
        s.start(new Stage());

    }
    
    @FXML
    private void Vol(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("SupprimerVol.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Ville(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("VilleDash.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Sejour(ActionEvent event) throws IOException { 
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Affichee.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Forum(ActionEvent event) throws IOException { 
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("FXMLAdminReclamation.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    private void Voiture(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent par = FXMLLoader.load(getClass().getResource("Garage.fxml"));
        Scene scene = new Scene(par);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }    
    
     
    
public Pane showStats() {
        Pane pane = new Pane();
        villeDAO ville = new villeDAO();
        circuitvipDAO circuit = new circuitvipDAO();
        HotelDAO hotel = new HotelDAO();
        sejourDAO sejour = new sejourDAO();
        volDAO vol = new volDAO();
        contentData= FXCollections.observableArrayList();
        contentData.add(new PieChart.Data("Villes", ville.countVilles()));
        contentData.add(new PieChart.Data("Circuits",circuit.countCircuit()));
        contentData.add(new PieChart.Data("Hotels", hotel.count()));
        contentData.add(new PieChart.Data("Sejours", sejour.count()));
        contentData.add(new PieChart.Data("Vols", vol.count()));

        final PieChart chartContent = new PieChart(contentData);
    
        chartContent.setTitle("PieChart");
        chartContent.setLayoutX(500);
        chartContent.setLayoutY(5);
        chartContent.setPrefWidth(350);
 
    //chartContent.setRotationAxis(Rotate.X_AXIS);
    //chartContent.setRotate(-65);
       
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
        bc.setTitle("BarChart");
        xAxis.setLabel("data");       
        yAxis.setLabel("Value");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Villes");       
        series1.getData().add(new XYChart.Data("Villes", ville.countVilles()));
        
         XYChart.Series series2 = new XYChart.Series();
        series2.setName("Circuits");       
        series2.getData().add(new XYChart.Data("Circuits",circuit.countCircuit()));
        bc.getData().addAll(series1, series2);
         pane.getChildren().addAll(bc,chartContent);
        
        return pane;


    }
       public void viewStats(ActionEvent e){
        if ((MenuItem) e.getSource() == showStats) {
            setStatsPane();
        }
        
        setupAnimation();
        
        
    }
     
     
         public void setStatsPane(){
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        panes.add(showStats());

        showPane.setItems(panes);
        showPane.setSelectionModel(null);

    }
         
             private void setupAnimation() {
        contentData.stream().forEach(pieData -> {
            System.out.println(pieData.getName() + ": " + pieData.getPieValue());
            pieData.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> { 
                Bounds b1 = pieData.getNode().getBoundsInLocal();
                double newX = (b1.getWidth()) / 2 + b1.getMinX();
                double newY = (b1.getHeight()) / 2 + b1.getMinY();
                // Make sure pie wedge location is reset
                pieData.getNode().setTranslateX(0);
                pieData.getNode().setTranslateY(0);
                
                // Show the BoundsInLocal of the selected wedge with a rectangle
//                rectangle.setTranslateX(newX);
//                rectangle.setTranslateY(newY);
//                rectangle.setWidth(b1.getWidth());
//                rectangle.setHeight(b1.getHeight());

                // Create the animation
                TranslateTransition tt = new TranslateTransition(
                        Duration.millis(1500), pieData.getNode());
                tt.setByX(newX);
                tt.setByY(newY);
                tt.setAutoReverse(true);
                tt.setCycleCount(2);
                tt.play();
            });
        });
    }
             
             public Pane showStat2() {
        Pane pane = new Pane();
        villeDAO ville = new villeDAO();
        circuitvipDAO circuit = new circuitvipDAO();
        contentData= FXCollections.observableArrayList();
        contentData.add(new PieChart.Data("Tunisie", ville.countPays("Tunisie")));
        contentData.add(new PieChart.Data("France",ville.countPays("France")));
        contentData.add(new PieChart.Data("Allemagne",ville.countPays("Allemagne")));
        contentData.add(new PieChart.Data("Dubai",ville.countPays("Dubai")));
        contentData.add(new PieChart.Data("Italie",ville.countPays("Italie")));
        contentData.add(new PieChart.Data("Espagne",ville.countPays("Espagne")));
        contentData.add(new PieChart.Data("Algerie",ville.countPays("Algerie")));
        contentData.add(new PieChart.Data("Australie",ville.countPays("Australie")));
        contentData.add(new PieChart.Data("Belgique",ville.countPays("Belgique")));
        contentData.add(new PieChart.Data("Maroc",ville.countPays("Maroc")));
        contentData.add(new PieChart.Data("Chine",ville.countPays("Chine")));
        contentData.add(new PieChart.Data("Irlande",ville.countPays("Irlande")));
        contentData.add(new PieChart.Data("Japon",ville.countPays("Japon")));
        contentData.add(new PieChart.Data("Mexique",ville.countPays("Mexique")));
        contentData.add(new PieChart.Data("Portugal",ville.countPays("Portugal")));
        contentData.add(new PieChart.Data("Espagne",ville.countPays("Espagne")));
        contentData.add(new PieChart.Data("Suède",ville.countPays("Suède")));
        contentData.add(new PieChart.Data("Suisse",ville.countPays("Suisse")));
         contentData.add(new PieChart.Data("Thaïlande",ville.countPays("Thaïlande")));


    

        final PieChart chartContent = new PieChart(contentData);
        chartContent.setTitle("Pays");
        chartContent.setLayoutX(500);
        chartContent.setLayoutY(5);
        chartContent.setPrefWidth(350);
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
        new BarChart<>(xAxis,yAxis);
        bc.setTitle("Les langues");
        xAxis.setLabel("data");       
        yAxis.setLabel("Value");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Arabe");       
        series1.getData().add(new XYChart.Data("Arabe", ville.countLangue("Arabe")));
        
        
         XYChart.Series series2 = new XYChart.Series();
        series2.setName("Français");       
        series2.getData().add(new XYChart.Data("Français",ville.countLangue("Français")));
        
         XYChart.Series series3 = new XYChart.Series();
        series3.setName("Allemand");       
        series3.getData().add(new XYChart.Data("Allemand",ville.countLangue("Allemand")));
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("brésilien");       
        series4.getData().add(new XYChart.Data("brésilien",ville.countLangue("brésilien")));
        
        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Turc");       
        series5.getData().add(new XYChart.Data("Turc",ville.countLangue("Turc")));
        
        
        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Chinois");       
        series6.getData().add(new XYChart.Data("Chinois",ville.countLangue("Chinois")));
        
        XYChart.Series series7 = new XYChart.Series();
        series7.setName("Coreen");       
        series7.getData().add(new XYChart.Data("Coreen",ville.countLangue("Coreen")));
        
        
        XYChart.Series series8 = new XYChart.Series();
        series8.setName("Hindi");       
        series8.getData().add(new XYChart.Data("Hindi",ville.countLangue("Hindi")));
        
        
        XYChart.Series series9 = new XYChart.Series();
        series9.setName("Roumain");       
        series9.getData().add(new XYChart.Data("Roumain",ville.countLangue("Roumain")));
        XYChart.Series series10 = new XYChart.Series();
        series10.setName("Italien");       
        series10.getData().add(new XYChart.Data("Italien",ville.countLangue("Italien")));
          XYChart.Series series11 = new XYChart.Series();
        series10.setName("Anglais");       
        series10.getData().add(new XYChart.Data("Anglais",ville.countLangue("Anglais")));
        
        bc.getData().addAll(series1, series2,series3,series4,series5,series6,series7,series8,series9,series10,series11);
         pane.getChildren().addAll(bc,chartContent);
       
        
       
         
        
        return pane;


    }
           
               public void viewStat2(ActionEvent e){
        if ((MenuItem) e.getSource() == showStat2) {
            setStat2Pane();
        }
        
        setupAnimation();
        
        
    }
                  public void setStat2Pane(){
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        panes.add(showStat2());

        showPane.setItems(panes);
        showPane.setSelectionModel(null);

    }    
    
    
}
