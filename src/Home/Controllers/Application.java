package Home.Controllers;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import Home.Models.*;
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
    private TextField txtF_ACF_festivalName, txtF_ACF_VIP, txtF_ACF_Standard, txtF_ACF_corporate, txtF_ACF_venue, txtF_ACF_city, txtF_ACF_postcode, txtF_ACF_tickets_available, txtF_ACF_event_type;

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
    private Button btn_ACF_saveSQL, btn_ACF_Lineup_1_save, btn_ACF_Lineup_2_save, btn_ACF_Lineup_3_save, brn_ACF_Lineup_4_save;

    //Tab : line up 1 text fields
    @FXML
    private TextField txtF_ACF_Lineup_1_bandName, txtF_ACF_Lineup_1_agentEmail, txtF_ACF_Lineup_1_agentFirstName, txtF_ACF_Lineup_1_agentLastName, txtF_ACF_Lineup_1_agentNo, txtF_ACF_Lineup_1_Artist_1_FirstName, txtF_ACF_Lineup_1_Artist_1_lastName, txtF_ACF_Lineup_1_Artist_2_FirstName, txtF_ACF_Lineup_1_Artist_2_lastName, txtF_ACF_Lineup_1_Artist_3_FirstName, txtF_ACF_Lineup_1_Artist_3_lastName, txtF_ACF_Lineup_1_Artist_4_FirstName, txtF_ACF_Lineup_1_Artist_4_lastName, txtF_ACF_Lineup_1_Artist_5_FirstName, txtF_ACF_Lineup_1_Artist_5_lastName;

    //Tab : line up 2 text fields
    @FXML
    private TextField txtF_ACF_Lineup_2_bandName, txtF_ACF_Lineup_2_agentEmail, txtF_ACF_Lineup_2_agentFirstName, txtF_ACF_Lineup_2_agentLastName, txtF_ACF_Lineup_2_agentNo, txtF_ACF_Lineup_2_Artist_1_FirstName, txtF_ACF_Lineup_2_Artist_1_lastName, txtF_ACF_Lineup_2_Artist_2_FirstName, txtF_ACF_Lineup_2_Artist_2_lastName, txtF_ACF_Lineup_2_Artist_3_FirstName, txtF_ACF_Lineup_2_Artist_3_lastName, txtF_ACF_Lineup_2_Artist_4_FirstName, txtF_ACF_Lineup_2_Artist_4_lastName, txtF_ACF_Lineup_2_Artist_5_FirstName, txtF_ACF_Lineup_2_Artist_5_lastName;

    //Tab : line up 3 text fields
    @FXML
    private TextField txtF_ACF_Lineup_3_bandName, txtF_ACF_Lineup_3_agentEmail, txtF_ACF_Lineup_3_agentFirstName, txtF_ACF_Lineup_3_agentLastName, txtF_ACF_Lineup_3_agentNo, txtF_ACF_Lineup_3_Artist_1_FirstName, txtF_ACF_Lineup_3_Artist_1_lastName, txtF_ACF_Lineup_3_Artist_2_FirstName, txtF_ACF_Lineup_3_Artist_2_lastName, txtF_ACF_Lineup_3_Artist_3_FirstName, txtF_ACF_Lineup_3_Artist_3_lastName, txtF_ACF_Lineup_3_Artist_4_FirstName, txtF_ACF_Lineup_3_Artist_4_lastName, txtF_ACF_Lineup_3_Artist_5_FirstName, txtF_ACF_Lineup_3_Artist_5_lastName;

    //Tab : line up 4 text fields
    @FXML
    private TextField txtF_ACF_Lineup_4_bandName, txtF_ACF_Lineup_4_agentEmail, txtF_ACF_Lineup_4_agentFirstName, txtF_ACF_Lineup_4_agentLastName, txtF_ACF_Lineup_4_agentNo, txtF_ACF_Lineup_4_Artist_1_FirstName, txtF_ACF_Lineup_4_Artist_1_lastName, txtF_ACF_Lineup_4_Artist_2_FirstName, txtF_ACF_Lineup_4_Artist_2_lastName, txtF_ACF_Lineup_4_Artist_3_FirstName, txtF_ACF_Lineup_4_Artist_3_lastName, txtF_ACF_Lineup_4_Artist_4_FirstName, txtF_ACF_Lineup_4_Artist_4_lastName, txtF_ACF_Lineup_4_Artist_5_FirstName, txtF_ACF_Lineup_4_Artist_5_lastName;

    private User currentUser;


    public UserDAO userDAO;

    private Festival currentFestival;
    public FestivalDAO festivalDAO;

    private Artist currentArtist;
    public ArtistDAO artistDAO;
    public List<Artist> artists = new ArrayList<Artist>();

    private Agent currentAgent;
    public AgentDAO agentDAO;

    private Band currentBand;
    public BandDAO lineUpDAO;

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

    ////////////////////////////My Account////////////////////////////////////////////////////////////////////////////////////

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
        txtF_EA_contactNo.setText(user.getContactNumber());
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
        user.setContactNumber(txtF_EA_contactNo.getText());
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

    //////////////////////////ADD Festival///////////////////////////////////////////////////////////////////////

    public void setFestivalDetails(Festival festival) {
        currentFestival = festival;

        txtF_ACF_festivalName.setText(festival.getFestival_name());
        txtF_ACF_venue.setText(festival.getVenue());
        txtF_ACF_city.setText(festival.getCity());
        txtF_ACF_postcode.setText(festival.getPostcode());
        //txtF_ACF_VIP.setText(festival.getTicket_price());
        txtF_ACF_corporate.setText(festival.getTicket_price());
        // txtF_ACF_Standard.setText(festival.getTicket_price());
        txtF_ACF_tickets_available.setText(festival.getTickets_available());
        txtF_ACF_event_type.setText(festival.getEvent_type());
        txtF_ACF_description.setText(festival.getDescription());
        date_ACF.setValue(LocalDate.parse(festival.getDate(true)));

        // date_ACF.setAccessibleText(festival.getDate(true));
        //String date1 = date_ACF.format(DateTimeFormatter.ofPattern("dd/mm/yyyyy"));
    }

    public void saveAddFestivalButton() {

        Festival festival = new Festival();
        currentFestival = festival;
        currentFestival.setFestival_name(txtF_ACF_festivalName.getText());
        currentFestival.setVenue(txtF_ACF_venue.getText());
        currentFestival.setCity(txtF_ACF_city.getText());
        currentFestival.setPostcode(txtF_ACF_postcode.getText());
        //festival.setTicket_price(txtF_ACF_corporate.getText());
        //festival.setTicket_price(txtF_ACF_VIP.getText());
        currentFestival.setTicket_price(txtF_ACF_Standard.getText());
        currentFestival.setTickets_available(txtF_ACF_tickets_available.getText());
        currentFestival.setEvent_type(txtF_ACF_event_type.getText());
        currentFestival.setDescription(txtF_ACF_description.getText());
        //festival.setDate(false,date_ACF.getAccessibleText());
        currentFestival.setDate(false, date_ACF.getValue().toString());

        Agent agent = currentAgent;
        new AgentDAO().addAgent(agent);
        try {
            currentAgent = new AgentDAO().getAgent(agent.getAgent_email());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        artists.get(0).setAgent_id(String.valueOf(currentAgent.getId()));
        artists.get(1).setAgent_id(String.valueOf(currentAgent.getId()));
        artists.get(2).setAgent_id(String.valueOf(currentAgent.getId()));
        artists.get(3).setAgent_id(String.valueOf(currentAgent.getId()));
        artists.get(4).setAgent_id(String.valueOf(currentAgent.getId()));

        new ArtistDAO().addArtist(artists.get(0));
        new ArtistDAO().addArtist(artists.get(1));
        new ArtistDAO().addArtist(artists.get(2));
        new ArtistDAO().addArtist(artists.get(3));
        new ArtistDAO().addArtist(artists.get(4));
        Artist artist ;
        for (int i = 0; i < artists.size(); i++) {
            try {
                artist = new ArtistDAO().getArtist(artists.get(i));
                artists.set(i, artist);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        currentBand.setAgentId(artists.get(0).getAgent_id());
        new BandDAO().addBand(currentBand);
        Band dbBand = currentBand;
        try {
            currentBand = new BandDAO().getBand(dbBand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        currentFestival.setBand_id(String.valueOf(currentBand.getId()));
        new FestivalDAO().addFestival(currentFestival);
    }

    public void setArtistDeatits(Artist artist) {
        currentArtist = artist;
        ///line up 1
        txtF_ACF_Lineup_1_Artist_1_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_1_Artist_1_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_1_Artist_2_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_1_Artist_2_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_1_Artist_3_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_1_Artist_3_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_1_Artist_4_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_1_Artist_4_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_1_Artist_5_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_1_Artist_5_lastName.setText(artist.getLast_name());

        /////line up 2
        txtF_ACF_Lineup_2_Artist_1_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_2_Artist_1_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_2_Artist_2_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_2_Artist_2_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_2_Artist_3_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_2_Artist_3_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_2_Artist_4_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_2_Artist_4_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_2_Artist_5_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_2_Artist_5_lastName.setText(artist.getLast_name());

        ///line up 3
        txtF_ACF_Lineup_3_Artist_1_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_3_Artist_1_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_3_Artist_2_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_3_Artist_2_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_3_Artist_3_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_3_Artist_3_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_3_Artist_4_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_3_Artist_4_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_3_Artist_5_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_3_Artist_5_lastName.setText(artist.getLast_name());

        /////line up 4//
        txtF_ACF_Lineup_4_Artist_1_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_4_Artist_1_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_4_Artist_2_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_4_Artist_2_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_4_Artist_3_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_4_Artist_3_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_4_Artist_4_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_4_Artist_4_lastName.setText(artist.getLast_name());

        txtF_ACF_Lineup_4_Artist_5_FirstName.setText(artist.getFirst_name());
        txtF_ACF_Lineup_4_Artist_5_lastName.setText(artist.getLast_name());


    }

    public void setAgentDeatils(Agent agent) {
        currentAgent = agent;

        //////line up 1
        txtF_ACF_Lineup_1_agentFirstName.setText(agent.getFirst_name());
        txtF_ACF_Lineup_1_agentLastName.setText(agent.getLast_name());
        txtF_ACF_Lineup_1_agentEmail.setText(agent.getAgent_email());
        txtF_ACF_Lineup_1_agentNo.setText(agent.getAgent_contact_no().toString());

        //line up 2
        txtF_ACF_Lineup_2_agentFirstName.setText(agent.getFirst_name());
        txtF_ACF_Lineup_2_agentLastName.setText(agent.getLast_name());
        txtF_ACF_Lineup_2_agentEmail.setText(agent.getAgent_email());
        txtF_ACF_Lineup_2_agentNo.setText(agent.getAgent_contact_no().toString());

        ///line up 3
        txtF_ACF_Lineup_3_agentFirstName.setText(agent.getFirst_name());
        txtF_ACF_Lineup_3_agentLastName.setText(agent.getLast_name());
        txtF_ACF_Lineup_3_agentEmail.setText(agent.getAgent_email());
        txtF_ACF_Lineup_3_agentNo.setText(agent.getAgent_contact_no().toString());

        ///line up 4
        txtF_ACF_Lineup_4_agentFirstName.setText(agent.getFirst_name());
        txtF_ACF_Lineup_4_agentLastName.setText(agent.getLast_name());
        txtF_ACF_Lineup_4_agentEmail.setText(agent.getAgent_email());
        txtF_ACF_Lineup_4_agentNo.setText(agent.getAgent_contact_no().toString());
    }

    public void setLineUpDetails(Band band) {
        currentBand = band;

        ///line up 1
        txtF_ACF_Lineup_1_bandName.setText(band.getBandName());

        ///line up 2
        txtF_ACF_Lineup_2_bandName.setText(band.getBandName());

        ///line up 3
        txtF_ACF_Lineup_3_bandName.setText(band.getBandName());

        ///line up 4
        txtF_ACF_Lineup_4_bandName.setText(band.getBandName());
    }

    public void saveLineUp1() {

        Agent agent = new Agent();
        currentAgent = new Agent();

        artists.add(new Artist());
        artists.add(new Artist());
        artists.add(new Artist());
        artists.add(new Artist());
        artists.add(new Artist());


        Band band = new Band();
        currentBand = band;


        ////////line up 1
        artists.get(0).setFirst_name(txtF_ACF_Lineup_1_Artist_1_FirstName.getText());
        artists.get(0).setLast_name(txtF_ACF_Lineup_1_Artist_1_lastName.getText());

        artists.get(1).setFirst_name(txtF_ACF_Lineup_1_Artist_2_FirstName.getText());
        artists.get(1).setLast_name(txtF_ACF_Lineup_1_Artist_2_lastName.getText());

        artists.get(2).setFirst_name(txtF_ACF_Lineup_1_Artist_3_FirstName.getText());
        artists.get(2).setLast_name(txtF_ACF_Lineup_1_Artist_3_lastName.getText());

        artists.get(3).setFirst_name(txtF_ACF_Lineup_1_Artist_4_FirstName.getText());
        artists.get(3).setLast_name(txtF_ACF_Lineup_1_Artist_4_lastName.getText());

        artists.get(4).setFirst_name(txtF_ACF_Lineup_1_Artist_5_FirstName.getText());
        artists.get(4).setLast_name(txtF_ACF_Lineup_1_Artist_5_lastName.getText());

        currentAgent.setFirst_name(txtF_ACF_Lineup_1_agentFirstName.getText());
        currentAgent.setLast_name(txtF_ACF_Lineup_1_agentLastName.getText());
        currentAgent.setAgent_email(txtF_ACF_Lineup_1_agentEmail.getText());
        currentAgent.setAgent_contact_no(txtF_ACF_Lineup_1_agentNo.getText());

        currentBand.setBandName(txtF_ACF_Lineup_1_bandName.getText());

    }

    public void saveLineUp2() {
        Artist artist = new Artist();
        currentArtist = artist;

        Agent agent = new Agent();
        currentAgent = agent;

        Band band = new Band();
        currentBand = band;

        ///////// line up 2
        artist.setFirst_name(txtF_ACF_Lineup_2_Artist_1_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_2_Artist_1_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_2_Artist_2_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_2_Artist_2_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_2_Artist_3_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_2_Artist_3_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_2_Artist_4_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_2_Artist_4_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_2_Artist_5_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_2_Artist_5_lastName.getText());

        agent.setFirst_name(txtF_ACF_Lineup_2_agentFirstName.getText());
        agent.setLast_name(txtF_ACF_Lineup_2_agentLastName.getText());
        agent.setAgent_email(txtF_ACF_Lineup_2_agentEmail.getText());
        agent.setAgent_contact_no(txtF_ACF_Lineup_2_agentNo.getText());

        band.setBandName(txtF_ACF_Lineup_2_bandName.getText());
        new ArtistDAO().addArtist(artist);
        new AgentDAO().addAgent(agent);
        new BandDAO().addBand(band);

    }

    public void saveLineUp3() {
        Artist artist = new Artist();
        currentArtist = artist;

        Agent agent = new Agent();
        currentAgent = agent;

        Band lineUp = new Band();
        currentBand = lineUp;

        ///line up 3
        artist.setFirst_name(txtF_ACF_Lineup_3_Artist_1_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_3_Artist_1_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_3_Artist_2_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_3_Artist_2_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_3_Artist_3_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_3_Artist_3_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_3_Artist_4_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_3_Artist_4_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_3_Artist_5_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_3_Artist_5_lastName.getText());

        agent.setFirst_name(txtF_ACF_Lineup_3_agentFirstName.getText());
        agent.setLast_name(txtF_ACF_Lineup_3_agentLastName.getText());
        agent.setAgent_email(txtF_ACF_Lineup_3_agentEmail.getText());
        agent.setAgent_contact_no(txtF_ACF_Lineup_3_agentNo.getText());

        lineUp.setBandName(txtF_ACF_Lineup_3_bandName.getText());
        new ArtistDAO().addArtist(artist);
        new AgentDAO().addAgent(agent);
        new BandDAO().addBand(lineUp);
    }

    public void saveLineUp4() {
        Artist artist = new Artist();
        currentArtist = artist;

        Agent agent = new Agent();
        currentAgent = agent;

        Band lineUp = new Band();
        currentBand = lineUp;
        ///line up 4
        artist.setFirst_name(txtF_ACF_Lineup_4_Artist_1_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_4_Artist_1_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_4_Artist_2_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_4_Artist_2_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_4_Artist_3_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_4_Artist_3_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_4_Artist_4_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_4_Artist_4_lastName.getText());

        artist.setFirst_name(txtF_ACF_Lineup_4_Artist_5_FirstName.getText());
        artist.setLast_name(txtF_ACF_Lineup_4_Artist_5_lastName.getText());

        agent.setFirst_name(txtF_ACF_Lineup_4_agentFirstName.getText());
        agent.setLast_name(txtF_ACF_Lineup_4_agentLastName.getText());
        agent.setAgent_email(txtF_ACF_Lineup_4_agentEmail.getText());
        agent.setAgent_contact_no(txtF_ACF_Lineup_4_agentNo.getText());

        lineUp.setBandName(txtF_ACF_Lineup_4_bandName.getText());

        new ArtistDAO().addArtist(artist);
        new AgentDAO().addAgent(agent);
        new BandDAO().addBand(lineUp);

    }


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //todo
        // setAccountInformation();
    }
}


