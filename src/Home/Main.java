package Home;

import Home.Models.DatabaseUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Views/registrationPages.fxml"));
        primaryStage.setTitle("Global Music");
        primaryStage.setScene(new Scene(root, 800, 600));



        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            DatabaseUtility.getInstance().connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        launch(args);


    }}

