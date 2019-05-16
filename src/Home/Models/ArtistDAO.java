package Home.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDAO {

    public void ArtistDAO() {
    }


    public boolean addArtist(Artist artist) {
        boolean queryPassed = true;
        try {
            Connection connection = DatabaseUtility.getInstance().getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `ARTIST`( `first_name`, `last_name`, `agent_id`)VALUES (?,?,?);");
                preparedStatement.setString(1, artist.getFirst_name());
                preparedStatement.setString(2, artist.getLast_name());
                preparedStatement.setString(3, artist.getAgent_id());
                System.out.print(preparedStatement);
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

    public Artist getArtist (Artist artist)throws SQLException{
        Artist dbArtist = new Artist();
        Connection connection = DatabaseUtility.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `artist` WHERE `first_name` = ? AND `last_name` = ? AND `agent_id` = ?;");
        preparedStatement.setString(1,artist.getFirst_name());
        preparedStatement.setString(2,artist.getLast_name());
        preparedStatement.setString(3,artist.getAgent_id());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            dbArtist=setArtistDetails(rs);
        }
        return dbArtist;   }

    private static Artist setArtistDetails(ResultSet rs) throws SQLException {
        Artist artist;
        artist = new Artist();
        artist.setId(rs.getInt("id"));
        artist.setFirst_name(rs.getString("first_name"));
        artist.setLast_name(rs.getString("last_name"));
        artist.setAgent_id(rs.getString("agent_id"));
        return artist;
    }
}