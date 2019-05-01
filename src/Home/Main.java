package Home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/Application.fxml"));
        primaryStage.setTitle("Global Music");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

Boolean g = true;

    }

    public static void main(String[] args) {
        launch(args);


    }}

