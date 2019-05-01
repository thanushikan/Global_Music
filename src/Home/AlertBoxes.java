package Home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;








public class AlertBoxes {

    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); //can't click other windows
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMaxWidth(300);

        Label label1 = new Label();
        label1.setText(message);
        Label label2 = new Label();


        TextField textField = new TextField();
        textField.getPromptText();



        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> window.close());

        Button yesButton = new Button ("Yes   ");




        DialogPane layout = new DialogPane();
        layout.getChildren().add(cancelButton);
        layout.getChildren().add(yesButton);
        //layout.setAlignment(Pos.BOTTOM_RIGHT);

        Scene scence = new Scene(layout);
        window.setScene(scence);
        window.showAndWait();



    }







}
