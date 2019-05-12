package Home.Models;

import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseUtility {

    private static DatabaseUtility instance= new DatabaseUtility();

    private Connection connection;

    public DatabaseUtility(){

    }

    public static DatabaseUtility getInstance(){
        return instance;
    }
    public Connection getConnection() {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    /*public Connection getConnection(){
        String dbName="festivalbookingsystem";
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
    }*/
    public void connect() throws Exception {
        String dbName="festivalbookingsystem";
        String password = "";
        String userName = "root";
        if (connection != null)
            return;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName+"?useTimezone&serverTimezone=UTC",userName,password);
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName+"?useTimezone&serverTimezone=UTC",userName,password);
    }


    public void executeUpdate(String query)throws Exception
    {
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(query);
    }

    public void executeQuery(String query)throws Exception
    {
        Statement statement = getConnection().createStatement();
        statement.executeQuery(query);
    }
}
