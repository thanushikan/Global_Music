package Home.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LineUpDAO {


    public boolean addLineUp(LineUp lineUp) {
        boolean queryPassed = true;
        try {
            Connection connection = DatabaseUtility.getInstance().getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `LINEUP` (`performance_time`,`artist_id`,`performance_name` ) VALUES\n" +
                        " ('?','?','?');");

                preparedStatement.setString(1, lineUp.getPerformance_time());
                preparedStatement.setString(2, lineUp.getArtist_id());
                preparedStatement.setString(3, lineUp.getPerformance_name());

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

}



