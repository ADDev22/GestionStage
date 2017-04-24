package Models;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	 private  static Connection  connection;
	 static {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://a2server:3306/gestion_stage","a2lam","Ad001234");
			// System.out.println("Creation d'une connexion");
		 } catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 public static Connection getConnection()
	 {
		// System.out.println("Creation d'une connexion");
		 return connection;
	 }

}
