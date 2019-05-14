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
    private Pane pnl_MyAccount, pnl_EditAccount, pnl_ViewCF, pnl_MakeBooking, pnl_ViewBookings, pnl_AddCF, pnl_ManageCF, pnl_CustomerAccounts, pnl_ManageBookings, pnl_EditCF, pnl_SelectInvoice;

    @FXML
    private Button btn_MA_EditDetails, btn_ManageBookings, btn_EditCF, btn_Invoices, btn_Account, btn_ViewCF, btn_MakeBooking, btn_Book, btn_ViewBookings, btn_AddCF, btn_ManageCF, btn_CustomerAccounts, btn_Logout, btn_EA_Edit_Details, btn_EA_cancel, btn_EA_save;

    @FXML
    private Label lbl_EA_account_type;

    @FXML
    private TextField txtF_EA_firstName, txtF_EA_lastName, txtF_EA_add1, txtF_EA_add2, txtF_EA_county, txtF_EA_postcode, txtF_EA_ContactName, txtF_EA_town, txtF_EA_mobile_number, txtF_EA_contactNo, txtF_EA_web_address, txtF_EA_email, txtF_EA_orgName, txtF_EA_dob;

    //Pane Add Concerts / Festivals (Add CF)
    @FXML
    private TextField txtF_ACF_firstivalName, txtF_ACF_VIP, txtF_ACF_Standard, txtF_ACF_corporate, txtF_ACF_venue, txtF_ACF_city, txtF_ACF_postcode, txtF_ACF_tickets_available, txtF_ACF_event_type;

    //Pane Add CF
    @FXML
    private TextArea txtF_ACF_description;

    //Pane Add CF
    @FXML
    private DatePicker date_ACF;

    //Line up tabs; Pane Add CF
    @FXML
    private Tab tab_ACF_line_up_1, tab_ACF_line_up_2, tab_ACF_line_up_3, tab_ACF_line_up_4;

    //Save buttons for the line up tabs
    @FXML
    private Button txtF_ACF_Lineup_1_save, txtF_ACF_Lineup_2_save, txtF_ACF_Lineup_3_save, txtF_ACF_Lineup_4_save;

    //Tab : line up 1 text fields
    @FXML
    private TextField txtF_ACF_Lineup_1_performanceName, txtF_ACF_Lineup_1_time, txtF_ACF_Lineup_1_agentEmail, txtF_ACF_Lineup_1_agentFirstName, txtF_ACF_Lineup_1_agentLastName, txtF_ACF_Lineup_1_agentNo, txtF_ACF_Lineup_1_Artist_1_FirstName, txtF_ACF_Lineup_1_Artist_1_lastName, txtF_ACF_Lineup_1_Artist_2_FirstName, txtF_ACF_Lineup_1_Artist_2_lastName, txtF_ACF_Lineup_1_Artist_3_FirstName, txtF_ACF_Lineup_1_Artist_3_lastName, txtF_ACF_Lineup_1_Artist_4_FirstName, txtF_ACF_Lineup_1_Artist_4_lastName, txtF_ACF_Lineup_1_Artist_5_FirstName, txtF_ACF_Lineup_1_Artist_5_lastName;

    //Tab : line up 2 text fields
    @FXML
    private TextField txtF_ACF_Lineup_2_performanceName, txtF_ACF_Lineup_2_time, txtF_ACF_Lineup_2_agentEmail, txtF_ACF_Lineup_2_agentFirstName, txtF_ACF_Lineup_2_agentLastName, txtF_ACF_Lineup_2_agentNo, txtF_ACF_Lineup_2_Artist_1_FirstName, txtF_ACF_Lineup_2_Artist_1_lastName, txtF_ACF_Lineup_2_Artist_2_FirstName, txtF_ACF_Lineup_2_Artist_2_lastName, txtF_ACF_Lineup_2_Artist_3_FirstName, txtF_ACF_Lineup_2_Artist_3_lastName, txtF_ACF_Lineup_2_Artist_4_FirstName, txtF_ACF_Lineup_2_Artist_4_lastName, txtF_ACF_Lineup_2_Artist_5_FirstName, txtF_ACF_Lineup_2_Artist_5_lastName;

    //Tab : line up 3 text fields
    @FXML
    private TextField txtF_ACF_Lineup_3_performanceName, txtF_ACF_Lineup_3_time, txtF_ACF_Lineup_3_agentEmail, txtF_ACF_Lineup_3_agentFirstName, txtF_ACF_Lineup_3_agentLastName, txtF_ACF_Lineup_3_agentNo, txtF_ACF_Lineup_3_Artist_1_FirstName, txtF_ACF_Lineup_3_Artist_1_lastName, txtF_ACF_Lineup_3_Artist_2_FirstName, txtF_ACF_Lineup_3_Artist_2_lastName, txtF_ACF_Lineup_3_Artist_3_FirstName, txtF_ACF_Lineup_3_Artist_3_lastName, txtF_ACF_Lineup_3_Artist_4_FirstName, txtF_ACF_Lineup_3_Artist_4_lastName, txtF_ACF_Lineup_3_Artist_5_FirstName, txtF_ACF_Lineup_3_Artist_5_lastName;

    //Tab : line up 4 text fields
    @FXML
    private TextField txtF_ACF_Lineup_4_performanceName, txtF_ACF_Lineup_4_time, txtF_ACF_Lineup_4_agentEmail, txtF_ACF_Lineup_4_agentFirstName, txtF_ACF_Lineup_4_agentLastName, txtF_ACF_Lineup_4_agentNo, txtF_ACF_Lineup_4_Artist_1_FirstName, txtF_ACF_Lineup_3_Artist_1_lastName1, txtF_ACF_Lineup_4_Artist_2_FirstName, txtF_ACF_Lineup_4_Artist_2_lastName, txtF_ACF_Lineup_3_Artist_3_FirstName1, txtF_ACF_Lineup_4_Artist_3_lastName, txtF_ACF_Lineup_4_Artist_4_FirstName, txtF_ACF_Lineup_4_Artist_4_lastName, txtF_ACF_Lineup_4_Artist_5_FirstName, txtF_ACF_Lineup_4_Artist_5_lastName;

    private User currentUser;

    public UserDAO userDAO;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_Account) {
            pnl_EditAccount.toFront();
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
        } else if (event.getSource() == btn_AddCF) {
            pnl_AddCF.toFront();
        } else if (event.getSource() == btn_ManageCF) {
            pnl_ManageCF.toFront();
        } else if (event.getSource() == btn_CustomerAccounts) {
            pnl_CustomerAccounts.toFront();
        } else if (event.getSource() == btn_ManageBookings) {
            pnl_ManageBookings.toFront();
        } else if (event.getSource() == btn_EditCF) {
            pnl_EditCF.toFront();
        } else if (event.getSource() == btn_Invoices) {
            pnl_SelectInvoice.toFront();
        } else if (event.getSource() == btn_Logout) {

        }
    }

    public void setAccountInformation(User user) {
        currentUser = user;
        if (!user.getIsOrganiser() & !user.getIsCorporate() & !user.getIsAdmin()) {
            lbl_EA_account_type.setText("Regular");
        } else if (user.getIsOrganiser()) {
            lbl_EA_account_type.setText("Organiser");
        } else if (user.getIsAdmin()) {
            lbl_EA_account_type.setText("Admin");
        } else if (user.getIsCorporate()) {
            lbl_EA_account_type.setText("Corporate");
        }
        txtF_EA_firstName.setText(user.getFirstName());
        txtF_EA_lastName.setText(user.getLastName());
        txtF_EA_add1.setText(user.getAddressLine1());
        txtF_EA_add2.setText(user.getAddressLine2());
        txtF_EA_county.setText(user.getCounty());
        txtF_EA_postcode.setText(user.getPostcode());
        txtF_EA_town.setText(user.getTown());
        txtF_EA_email.setText(user.getEmailAddress());
        txtF_EA_mobile_number.setText(user.getMobileNumber());
        txtF_EA_contactNo.setText(user.getPhoneNumber());
        txtF_EA_ContactName.setText(user.getContactName());
        txtF_EA_web_address.setText(user.getWebAddress());
        txtF_EA_orgName.setText(user.getOrganisationName());
        txtF_EA_dob.setText(user.getDOB(true));
    }


    public void ClickEditMyAccountDetailsButton() {
        btn_EA_cancel.setVisible(true);
        btn_EA_save.setVisible(true);
        btn_EA_Edit_Details.setVisible(false);
        txtF_EA_firstName.setDisable(false);
        txtF_EA_lastName.setDisable(false);
        txtF_EA_add1.setDisable(false);
        txtF_EA_add2.setDisable(false);
        txtF_EA_county.setDisable(false);
        txtF_EA_postcode.setDisable(false);
        txtF_EA_town.setDisable(false);
        txtF_EA_email.setDisable(false);
        txtF_EA_mobile_number.setDisable(false);
        txtF_EA_contactNo.setDisable(false);
        txtF_EA_ContactName.setDisable(false);
        txtF_EA_web_address.setDisable(false);
        txtF_EA_orgName.setDisable(false);
        txtF_EA_dob.setDisable(false);
    }

    public void SaveMyAccountDetails() {
        User user;
        btn_EA_cancel.setVisible(false);
        btn_EA_save.setVisible(false);
        btn_EA_Edit_Details.setVisible(true);
        txtF_EA_firstName.setDisable(true);
        txtF_EA_lastName.setDisable(true);
        txtF_EA_add1.setDisable(true);
        txtF_EA_add2.setDisable(true);
        txtF_EA_county.setDisable(true);
        txtF_EA_postcode.setDisable(true);
        txtF_EA_town.setDisable(true);
        txtF_EA_email.setDisable(true);
        txtF_EA_mobile_number.setDisable(true);
        txtF_EA_contactNo.setDisable(true);
        txtF_EA_ContactName.setDisable(true);
        txtF_EA_web_address.setDisable(true);
        txtF_EA_orgName.setDisable(true);
        txtF_EA_dob.setDisable(true);

        user = currentUser;

        user.setFirstName(txtF_EA_firstName.getText());
        user.setLastName(txtF_EA_lastName.getText());
        user.setAddressLine1(txtF_EA_add1.getText());
        user.setAddressLine2(txtF_EA_add2.getText());
        user.setCounty(txtF_EA_county.getText());
        user.setPostcode(txtF_EA_postcode.getText());
        user.setTown(txtF_EA_town.getText());
        user.setEmailAddress(txtF_EA_email.getText());
        user.setMobileNumber(txtF_EA_mobile_number.getText());
        user.setPhoneNumber(txtF_EA_contactNo.getText());
        user.setContactName(txtF_EA_ContactName.getText());
        user.setWebAddress(txtF_EA_web_address.getText());
        user.setOrganisationName(txtF_EA_orgName.getText());
        user.setDOB(false, txtF_EA_dob.getText());
        try {
            new UserDAO().updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //todo
        // setAccountInformation();
    }
}


