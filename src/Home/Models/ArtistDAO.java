package Home.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArtistDAO {

    public void ArtistDAO(){}


    public boolean addArtist(Artist artist){
        boolean queryPassed = true;

        try {
            Connection connection = DatabaseUtility.getInstance().getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `ARTIST` (`first_name`,`last_name`,`agent_ id`) VALUES\n" +
                        " ('?','?','?');");

                preparedStatement.setString(1,artist.getFirst_name());
                preparedStatement.setString(2,artist.getLast_name());
                preparedStatement.setString(3,artist.getAgent_id());




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
    }

