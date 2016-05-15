/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyage.java;

import com.govoyage.GUI.StackEcrans;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


/**
 *
 * @author dell
 */
public class GOVOYAGEJAVA extends Application {
    
        public String navOnePays = "test.fxml"; //n
        public String Pays = "Home.fxml";
        public String navAdmin = "ListeVilleDash.fxml";

    public static final String APPLICATION_ICON =
             "com/govoyage/IMAGES/logo.jpg";
    public static final String SPLASH_IMAGE =
             "com/govoyage/IMAGES/logo.jpg";
    
    private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
   // private Stage mainStage;
    private static final int SPLASH_WIDTH = 945;
    private static final int SPLASH_HEIGHT = 450;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void init() throws IOException, URISyntaxException, Exception {
        ImageView splash = new ImageView(new Image(SPLASH_IMAGE));

        loadProgress = new ProgressBar();
        loadProgress.setStyle("-fx-accent: #1e5fac; -fx-border-color: black; -fx-border-radius: 20px;");
        loadProgress.setPrefWidth(SPLASH_WIDTH);
        progressText = new Label("Loading Modules . . .");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setStyle("-fx-background-color: rgba(255,255,255, 0.1);");
                final File file = new File("C:\\Users\\dell\\Desktop\\javaa\\GOVOYAGE-JAVA\\src\\com\\govoyage\\IMAGES\\Plane.mp3"); 
        final Media media = new Media(file.toURI().toString()); 
        final MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.play(); 
        mediaPlayer.setStopTime(Duration.seconds(17));
    }

    @Override
    public void start(final Stage initStage) throws Exception {
        final Task<ObservableList<String>> friendTask = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws InterruptedException {
                ObservableList<String> foundFriends =
                        FXCollections.<String>observableArrayList();
                ObservableList<String> availableFriends =
                        FXCollections.observableArrayList(
                               "Internet Connection");

                updateMessage("Startup Check  . . .");
                for (int i = 0; i < 15; i++) {
                    Thread.sleep(1000);
                    updateProgress(i + 1, 15);
                    /*String nextFriend = availableFriends.get(i);
                    
                     if(nextFriend.equals("Internet Connection")){
                        
                        if(Launcher.getInternetStatus() != 0)
                        {
                            updateMessage("You are Online ");
                        } 
                        else
                        {
                            updateMessage("You are Offline ");
                        }
                        //Thread.sleep(1000);
                    }*/
                }
                Thread.sleep(1500); 
                updateMessage("All friends found.");

                return foundFriends;
                
            }
        };

        showSplash(initStage,friendTask, () -> showMainStage()
        );
        new Thread(friendTask).start();
    }

    private void showMainStage() {
          try { 
        StackEcrans container = new StackEcrans();

            container.loadScreen("home", Pays);           

            container.setScreen("home");

            Scene scene = new Scene(container);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Home | GoVoyage");
            stage.resizableProperty().setValue(false); // Desactiver le resize
            stage.centerOnScreen();
            stage.show();
        
        
        
        
        } catch (Exception ex) {
            Logger.getLogger(GOVOYAGEJAVA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*mainStage = new Stage(StageStyle.DECORATED);
        mainStage.setTitle("My Friends");
        mainStage.getIcons().add(new Image(
                APPLICATION_ICON
        ));

        final ListView<String> peopleView = new ListView<>();
        peopleView.itemsProperty().bind(friends);

        mainStage.setScene(new Scene(peopleView));
        
        
        /*mainStage = new Stage(StageStyle.DECORATED);
        mainStage.setTitle("My Friends");
        mainStage.getIcons().add(new Image(
                APPLICATION_ICON
        ));

        final ListView<String> peopleView = new ListView<>();
        peopleView.itemsProperty().bind(friends);

        mainStage.setScene(new Scene(peopleView));
        mainStage.show();*/
    }

    
    
    
    
 
    
    
    
    private void showSplash(
            final Stage initStage,
            Task<?> task,
            GOVOYAGEJAVA.InitCompletionHandler initCompletionHandler
    ) throws Exception {
        progressText.textProperty().bind(task.messageProperty());
        loadProgress.progressProperty().bind(task.progressProperty());
        task.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                loadProgress.progressProperty().unbind();
                initStage.toFront();
                FadeTransition fadeSplash = new FadeTransition(Duration.seconds(5), splashLayout);
                fadeSplash.setFromValue(1.0);
                fadeSplash.setToValue(0.0);
                fadeSplash.setOnFinished(actionEvent -> initStage.hide());
                fadeSplash.play();

                initCompletionHandler.complete();
            }
        });
        


        Scene splashScene = new Scene(splashLayout);
        splashScene.setFill(null);
        initStage.initStyle(StageStyle.TRANSPARENT);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.show();
    }

    public interface InitCompletionHandler {
        public void complete();
    }
    
    
      public static int getInternetStatus(){
    try {
        URL siteURL = new URL("http", "www.google.com", 80, "www.google.com"); 
        HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                return code;
            }
        } catch (Exception e) {
            System.out.println("No available Internet Connection : " + e.getMessage());
        }
        return 0;
    }
    
}
