package Home.Controllers;


import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import Home.Models.User;
import Home.Models.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;



public class Application implements Initializable {
    @FXML
    private Pane pnl_MyAccount, pnl_EditAccount, pnl_ViewCF,pnl_MakeBooking,pnl_ViewBookings,pnl_AddCF,pnl_ManageCF,pnl_CustomerAccounts,pnl_ManageBookings,pnl_EditCF,pnl_SelectInvoice;

    @FXML
    private Button  btn_MA_EditDetails,btn_ManageBookings,btn_EditCF,btn_Invoices,btn_Account,btn_ViewCF,btn_MakeBooking,btn_Book,btn_ViewBookings,btn_AddCF,btn_ManageCF,btn_CustomerAccounts,btn_Logout;

    @FXML
    private TextField txtF_EA_firstName,txtF_EA_email;

    @FXML
    private List<Button> button;

    private User CurrentUser;

    @FXML
    private void bringToFront(Button buttonToFront){
        buttonToFront.toFront();
    }

    @FXML
    private void ClickMyAccount() {
        btn_Account.toFront();
    }

    @FXML
    private void ClickEditAccount(){
        pnl_EditAccount.toFront();
    }

    public UserDAO userDAO;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_Account) {
            pnl_MyAccount.toFront();
        } else if (event.getSource() == btn_MA_EditDetails) {
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
        else if (event.getSource() == btn_Logout)
        {

        }
    }

    public void setAccountInformation(User user){

        txtF_EA_email.setText(user.getEmailAddress());

    }

   @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //todo
       // setAccountInformation();


    }
}


