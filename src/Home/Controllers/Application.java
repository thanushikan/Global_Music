package Home.Controllers;



import java.net.URL;
import java.util.ResourceBundle;


import Home.Connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import  java.sql.*;
import javafx.scene.layout.Pane;


public class Application implements Initializable {
    @FXML
    private Pane pnl_ViewAccount, pnl_EditAccount, pnl_ViewCF,pnl_MakeBooking,pnl_ViewBookings,pnl_AddCF,pnl_ManageCF;

    @FXML
    private Pane pnl_CustomerAccounts,pnl_ManageBookings,pnl_EditCF,pnl_SelectInvoice;

    @FXML
    private Label lbl_ViewCF;

    @FXML
    private Hyperlink View;

    @FXML
    private Button btn_EditDetails,btn_ManageBookings,btn_EditCF,btn_Invoices;

    @FXML
    private Button btn_Account,btn_ViewCF,btn_MakeBooking,btn_Book,btn_ViewBookings,btn_AddCF,btn_ManageCF,btn_CustomerAccounts;

    public ConnectionClass connectionClass;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_Account) {
            try{
                connectionClass = new ConnectionClass();
                Connection connection = connectionClass.GetConnection();
                String sql= "INSERT INTO user('firstName', 'lastName', 'Address', 'Postcode') VALUES ('test1', 'test1', 'test1', 'test1')";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            }
            catch (Exception ex){
                System.out.println(ex.fillInStackTrace());
            }


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
        else if (event.getSource() == btn_Invoices){
            pnl_SelectInvoice.toFront();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }
}


