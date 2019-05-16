package Home.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BandDAO {


    public boolean addBand(Band band) {
        boolean queryPassed = true;
        try {
            Connection connection = DatabaseUtility.getInstance().getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `BAND` (`band_Name`,`agent_id`) VALUES(?,?);");
                preparedStatement.setString(1, band.getBandName());
                preparedStatement.setString(2, band.getAgentId());
                System.out.println(preparedStatement);
                preparedStatement.execute();



            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (
                Exception ex) {
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        } finally {
            return queryPassed;
        }

    }

    public Band getBand(Band band)throws SQLException {
        Band dbBand = new Band();
        Connection connection = DatabaseUtility.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `band` WHERE `band_name` =? AND `agent_id` = ?;");
        preparedStatement.setString(1, band.getBandName());
        preparedStatement.setString(2, band.getAgentId());
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            dbBand = setLineUpDetails(rs);
        }
        return dbBand;
    }


    private static Band setLineUpDetails(ResultSet rs) throws SQLException {
        Band band;
       band = new Band();
       band.setId(rs.getInt("id"));
       band.setBandName(rs.getString("band_name"));
       band.setAgentId(rs.getString("agent_id"));
        return band;
    }

}







