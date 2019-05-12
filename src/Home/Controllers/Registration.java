package Home.Controllers;



import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import Home.Models.User;
import Home.Models.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Registration implements Initializable {

    @FXML
    private Pane pnl_Regular,pnl_Login,pnl_RegOrg,pnl_Corporate,pnl_RegPaths;

    @FXML
    private Button btn_Login_CreateAccount,btn_Reg_Regular,btn_Reg_Org,btn_Reg_Corporate,btn_RegularUser_Register;

    @FXML
    private PasswordField txtbox_Login_Password;

    @FXML
    private TextField txtbox_Login_Username,txt_RegularUser_firstName,txt_RegularUser_LastName,txt_RegularUser_AddressLine1,txt_RegularUser_AddressLine2,txt_RegularUser_HomePhone,txt_RegularUser_Postcode,txt_RegularUser_Town,txt_RegularUser_County,txt_RegularUser_MobileNumber,txt_RegularUser_dob,txt_RegularUser_Email,txt_RegularUser_Password,txt_RegularUser_WebAddress,txt_RegularUser_OrganisationName,txt_RegularUser_ContactName,txt_RegularUser_CardHolderName,txt_RegularUser_CardNo,txt_RegularUser_CardExpireDate,txt_RegularUser_CardCvc;

    @FXML
    private  void SwitchWindow(ActionEvent event,String view,boolean resizeable,int minHeight,int minWidth){
     /*   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/" + view+".Views"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/" + view+".fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.close();
        //stage.hide();


        stage.setMinHeight(minHeight);
        stage.setMinWidth(minWidth);
        stage.setScene(new Scene(root));
        stage.setResizable(resizeable);
        stage.show();

    }

    @FXML
    private void Login(ActionEvent event) throws IOException {
        if (!new UserDAO().LoginUser(txtbox_Login_Username.getText(),txtbox_Login_Password.getText())){
            System.out.println("sorry mate no match please check your email and password");
        }
        else{
            try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/Application.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            Application appController = loader.getController();
            appController.setAccountInformation(new UserDAO().getUser(txtbox_Login_Username.getText()));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setMinHeight(600);
                stage.setMinWidth(800);
                stage.setScene(new Scene(root));
                stage.setResizable(true);
                stage.show();
            }
            catch (SQLException ex){
                System.out.println(ex.fillInStackTrace());

            }


        }
    }

    private FXMLLoader loader;


    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../Views/registrationPages.fxml"));
        primaryStage.setTitle("new window");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.hide();
        primaryStage.show();
    }


    @FXML
    private void ClickRegisterAccountBtn() {
             pnl_RegPaths.toFront();
    }

    @FXML
    private void ClickRegisterOrganiserButton() {
        pnl_RegOrg.toFront();
    }
    @FXML

    private void ClickRegisterRegularUser(){pnl_Regular.toFront();
        //txt_RegularUser_firstName.setVisible(false); set textfield to invisible
    }

    @FXML
    private void  ClickRegisterCorporateUser(){
        pnl_Corporate.toFront();
    }

    @FXML
    private void RegisterRegularUser() throws ParseException {

        if (txt_RegularUser_firstName.getText().equals("")) {
            //set label text "firstname is empty please enter a first name"
        }
        Boolean UserDetailsRegisteredSuccessfully= new UserDAO().registerUser( new User("MR",txt_RegularUser_firstName.getText(),txt_RegularUser_LastName.getText(),
                "MALE",txt_RegularUser_AddressLine1.getText(),txt_RegularUser_AddressLine2.getText(),
                txt_RegularUser_Town.getText(),txt_RegularUser_County.getText(),txt_RegularUser_Postcode.getText(),
                txt_RegularUser_dob.getText(),txt_RegularUser_ContactName.getText(),txt_RegularUser_OrganisationName.getText(),
                txt_RegularUser_Email.getText(),new BigInteger(txt_RegularUser_HomePhone.getText()), new BigInteger(txt_RegularUser_MobileNumber.getText()),
                txt_RegularUser_WebAddress.getText(),txt_RegularUser_Password.getText(),false,false,false));


       /* "MR",txt_RegularUser_firstName.getText(),txt_RegularUser_LastName.getText(),
                "MALE",txt_RegularUser_AddressLine1.getText(),txt_RegularUser_AddressLine2.getText(),
                txt_RegularUser_Town.getText(),txt_RegularUser_County.getText(),txt_RegularUser_Postcode.getText(),
                txt_RegularUser_dob.getText(),txt_RegularUser_ContactName.getText(),txt_RegularUser_OrganisationName.getText(),
                txt_RegularUser_Email.getText(),txt_RegularUser_HomePhone.getText(),txt_RegularUser_MobileNumber.getText(),
                txt_RegularUser_WebAddress.getText(),txt_RegularUser_Password.getText(),false,false,false*/

        /*Boolean PaymentDetailsRegisteredSuccessfully = new UserDAO().registerPaymentDetails(
                "0.00",txt_RegularUser_CardNo.getText(),txt_RegularUser_CardExpireDate.getText(),
                txt_RegularUser_CardHolderName.getText(),txt_RegularUser_CardCvc.getText());*/
        if (!UserDetailsRegisteredSuccessfully){
            System.out.println("User details were not registered correctly");
        }
        /*if (!PaymentDetailsRegisteredSuccessfully || !UserDetailsRegisteredSuccessfully){
            if (!PaymentDetailsRegisteredSuccessfully){
                System.out.println("Payment details were not registered correctly");
            }

        }*/
        else{
            pnl_Login.toFront();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }
}