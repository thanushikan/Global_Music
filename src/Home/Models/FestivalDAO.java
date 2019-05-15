package Home.Models;

import javafx.scene.layout.Pane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;


//CRUD
public class FestivalDAO {

    public void FestivalDAO() {
    }

    public boolean addFestival(Festival festival) {
        boolean queryPassed = true;
        try {
            Connection connection = DatabaseUtility.getInstance().getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `festival` (`city`, `postcode`, `date`, `festival_name`, `venue`, `description`, `tickets_available`, `line_up_id`, `ticket_price`, `event_type`) VALUES ( ?,?,?,?, ?, ?, ?,?, ?,?);");
                preparedStatement.setString(1, festival.getCity());

                preparedStatement.setString(2, festival.getPostcode());
                preparedStatement.setString(3, festival.getDate(false));
                preparedStatement.setString(4, festival.getFestival_name());
                preparedStatement.setString(5, festival.getVenue());
                preparedStatement.setString(6, festival.getDescription());
                preparedStatement.setString(7, festival.getTickets_available());
                preparedStatement.setString(8, festival.getLine_up_id());
                preparedStatement.setString(9, festival.getTicket_price());
                preparedStatement.setString(10, festival.getEvent_type());

                System.out.println(preparedStatement);
                preparedStatement.execute();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        } finally {
            return queryPassed;
        }
    }


    public void  getFestival(){

            }


 public void updateFestival(){


 }

 public void deleteFestival(){}



}

