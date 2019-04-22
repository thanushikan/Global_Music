package Home.Controllers;

import java.awt.*;
import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.responsive.JFXResponsiveHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;


public class Application implements Initializable {
    @FXML
    private Pane pnl_ViewAccount, pnl_EditAccount, pnl_ViewCF,pnl_MakeBooking,pnl_ViewBookings,pnl_AddCF,pnl_ManageCF;

    @FXML
    private Pane pnl_CustomerAccounts,pnl_ManageBookings,pnl_EditCF;



    @FXML
    private Button btn_EditDetails,btn_ManageBookings,btn_EditCF;

    @FXML
    private Button btn_Account,btn_ViewCF,btn_MakeBooking,btn_Book,btn_ViewBookings,btn_AddCF,btn_ManageCF,btn_CustomerAccounts;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_Account) {
            pnl_ViewAccount.toFront();

        } else if (event.getSource() == btn_EditDetails) {
            pnl_EditAccount.toFront();
        } else if (event.getSource() == btn_ViewCF) {
            pnl_ViewCF.toFront();
        } else if (event.getSource() == btn_Book) {
            pnl_MakeBooking.toFront();
        } else if (event.getSource() == btn_MakeBooking) {
            pnl_MakeBooking.toFront();
        } else if (event.getSource() == btn_ViewBookings) {
            pnl_ViewBookings.toFront();
        }
        else if (event.getSource() == btn_AddCF) {
            pnl_AddCF.toFront();
        }
        else if (event.getSource() == btn_ManageCF){
            pnl_ManageCF.toFront();
        }
        else if (event.getSource() == btn_CustomerAccounts){
            pnl_CustomerAccounts.toFront();
        }
        else if (event.getSource() == btn_ManageBookings){
            pnl_ManageBookings.toFront();
        }
        else if (event.getSource() == btn_EditCF){
            pnl_EditCF.toFront();
        }


    }






    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }
}


