package Home.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentDAO {


    public boolean addAgent(Agent agent) {
        boolean queryPassed = true;
        try {
            Connection connection = DatabaseUtility.getInstance().getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `AGENT` (`first_name`,`last_name`,`agent_contact_no`,`agent_email`) VALUES (?,?,?,?);");
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

    public Agent getAgent(String agentemail)throws SQLException{
        Agent agent = new Agent();
            Connection connection = DatabaseUtility.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `agent` WHERE `agent_email` = ?");
                preparedStatement.setString(1,agentemail);

                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                   agent  = setAgentDetails(rs);
                }
                return agent;
    }



    private static Agent setAgentDetails(ResultSet rs) throws SQLException {
        Agent agent;
        agent = new Agent();
        agent.setId(rs.getInt("id"));
        agent.setFirst_name(rs.getString("first_name"));
        agent.setLast_name(rs.getString("last_name"));
        agent.setAgent_contact_no(rs.getString("agent_contact_no"));
        agent.setAgent_email(rs.getString("agent_email"));
        return agent;
    }
}