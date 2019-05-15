package Home.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgentDAO {


    public boolean addAgent(Agent agent) {
        boolean queryPassed = true;
        try {
            Connection connection = DatabaseUtility.getInstance().getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `AGENT` (first_name`,`last_name`,agent_contract_no`,`agent_email`) VALUES (?,?,?,?);");
                preparedStatement.setString(1, agent.getFirst_name());
                preparedStatement.setString(2,agent.getLast_name());
                preparedStatement.setString(3,agent.getAgent_contact_no().toString());
                preparedStatement.setString(4,agent.getAgent_email());

                System.out.println(preparedStatement);
                preparedStatement.execute();



            }
            catch (SQLException e) {
            }
        }catch (Exception ex){
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        } finally {
            return queryPassed;
        }

    }


}

