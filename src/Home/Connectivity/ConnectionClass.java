package Home.Connectivity;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public  Connection connection;
    public Connection GetConnection(){
        String dbName="FestivalBookingStystem";
        String password = "";
        String userName = "root";
        try
        {
           // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName+"?useTimezone&serverTimezone=UTC",userName,password);
        }
        catch(Exception ex) {
           // System.out.println("Error: unable to load driver class!");
            System.out.println(ex.getCause());
            System.exit(1);
        }
        return connection;
    }


}
