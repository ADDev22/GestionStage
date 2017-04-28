package Models;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	 private  static Connection  connection;
	 static {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:8889/gestionStage","BDPrStage","");
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
