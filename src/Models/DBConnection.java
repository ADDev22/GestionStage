package tp2_jdbc_swing;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	private static DBConnection instance;
    private String url="jdbc:mysql://a2server:3306/";
    private String dbName = "tp2_jdbc_swing";
    private String driver = "com.mysql.jdbc.Driver";
    private String login="a2lam";
    private String pass="Ad001234";

    private DBConnection(){

        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
            System.out.println(" Connection  - - - - - - - -  New DBConnection created");
        }
        try {
            return (Connection) DriverManager.getConnection(instance.url + instance.dbName, instance.login,instance.pass);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void close(Connection connection)
    {
        try {
            if (connection != null) {
                connection.close();
                connection=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
