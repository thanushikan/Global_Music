package Home.Controllers;


import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import Home.Models.User;
import Home.Models.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;



public class Application implements Initializable {
    @FXML
    private Pane pnl_MyAccount, pnl_EditAccount, pnl_ViewCF,pnl_MakeBooking,pnl_ViewBookings,pnl_AddCF,pnl_ManageCF,pnl_CustomerAccounts,pnl_ManageBookings,pnl_EditCF,pnl_SelectInvoice;

    @FXML
    private Button  btn_MA_EditDetails,btn_ManageBookings,btn_EditCF,btn_Invoices,btn_Account,btn_ViewCF,btn_MakeBooking,btn_Book,btn_ViewBookings,btn_AddCF,btn_ManageCF,btn_CustomerAccounts,btn_Logout;

    @FXML
    private TextField txtF_EA_firstName,txtF_EA_email;

    //Pane Add Concerts / Festivals (Add CF)
    @FXML
    private TextField txtF_ACF_firstivalName,txtF_ACF_VIP,txtF_ACF_Standard,txtF_ACF_corporate,txtF_ACF_venue,txtF_ACF_city,txtF_ACF_postcode,txtF_ACF_tickets_available,txtF_ACF_event_type;

    //Pane Add CF
    @FXML
    private TextArea txtF_ACF_description;

    //Pane Add CF
    @FXML
    private DatePicker date_ACF;

    //Line up tabs; Pane Add CF
    @FXML
    private Tab tab_ACF_line_up_1,tab_ACF_line_up_2,tab_ACF_line_up_3,tab_ACF_line_up_4;

    //Save buttons for the line up tabs
    @FXML
    private Button txtF_ACF_Lineup_1_save,txtF_ACF_Lineup_2_save,txtF_ACF_Lineup_3_save,txtF_ACF_Lineup_4_save;

    //Tab : line up 1 text fields
    @FXML
    private TextField txtF_ACF_Lineup_1_performanceName,txtF_ACF_Lineup_1_time,txtF_ACF_Lineup_1_agentEmail,txtF_ACF_Lineup_1_agentFirstName,txtF_ACF_Lineup_1_agentLastName,txtF_ACF_Lineup_1_agentNo,txtF_ACF_Lineup_1_Artist_1_FirstName,txtF_ACF_Lineup_1_Artist_1_lastName,txtF_ACF_Lineup_1_Artist_2_FirstName,txtF_ACF_Lineup_1_Artist_2_lastName,txtF_ACF_Lineup_1_Artist_3_FirstName,txtF_ACF_Lineup_1_Artist_3_lastName,txtF_ACF_Lineup_1_Artist_4_FirstName,txtF_ACF_Lineup_1_Artist_4_lastName,txtF_ACF_Lineup_1_Artist_5_FirstName,txtF_ACF_Lineup_1_Artist_5_lastName;

    //Tab : line up 2 text fields
    @FXML
    private TextField txtF_ACF_Lineup_2_performanceName,txtF_ACF_Lineup_2_time,txtF_ACF_Lineup_2_agentEmail,txtF_ACF_Lineup_2_agentFirstName,txtF_ACF_Lineup_2_agentLastName,txtF_ACF_Lineup_2_agentNo,txtF_ACF_Lineup_2_Artist_1_FirstName,txtF_ACF_Lineup_2_Artist_1_lastName,txtF_ACF_Lineup_2_Artist_2_FirstName,txtF_ACF_Lineup_2_Artist_2_lastName,txtF_ACF_Lineup_2_Artist_3_FirstName,txtF_ACF_Lineup_2_Artist_3_lastName,txtF_ACF_Lineup_2_Artist_4_FirstName,txtF_ACF_Lineup_2_Artist_4_lastName,txtF_ACF_Lineup_2_Artist_5_FirstName,txtF_ACF_Lineup_2_Artist_5_lastName;

    //Tab : line up 3 text fields
    @FXML
    private TextField txtF_ACF_Lineup_3_performanceName,txtF_ACF_Lineup_3_time,txtF_ACF_Lineup_3_agentEmail,txtF_ACF_Lineup_3_agentFirstName,txtF_ACF_Lineup_3_agentLastName,txtF_ACF_Lineup_3_agentNo,txtF_ACF_Lineup_3_Artist_1_FirstName,txtF_ACF_Lineup_3_Artist_1_lastName,txtF_ACF_Lineup_3_Artist_2_FirstName,txtF_ACF_Lineup_3_Artist_2_lastName,txtF_ACF_Lineup_3_Artist_3_FirstName,txtF_ACF_Lineup_3_Artist_3_lastName,txtF_ACF_Lineup_3_Artist_4_FirstName,txtF_ACF_Lineup_3_Artist_4_lastName,txtF_ACF_Lineup_3_Artist_5_FirstName,txtF_ACF_Lineup_3_Artist_5_lastName;

    //Tab : line up 4 text fields
    @FXML
    private TextField txtF_ACF_Lineup_4_performanceName,txtF_ACF_Lineup_4_time,txtF_ACF_Lineup_4_agentEmail,txtF_ACF_Lineup_4_agentFirstName,txtF_ACF_Lineup_4_agentLastName,txtF_ACF_Lineup_4_agentNo,txtF_ACF_Lineup_4_Artist_1_FirstName,txtF_ACF_Lineup_3_Artist_1_lastName1,txtF_ACF_Lineup_4_Artist_2_FirstName,txtF_ACF_Lineup_4_Artist_2_lastName,txtF_ACF_Lineup_3_Artist_3_FirstName1,txtF_ACF_Lineup_4_Artist_3_lastName,txtF_ACF_Lineup_4_Artist_4_FirstName,txtF_ACF_Lineup_4_Artist_4_lastName,txtF_ACF_Lineup_4_Artist_5_FirstName,txtF_ACF_Lineup_4_Artist_5_lastName;



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
       // https://www.youtube.com/watch?v=d6OOxLd1Ars
    }

   @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //todo
       // setAccountInformation();


    }
}


