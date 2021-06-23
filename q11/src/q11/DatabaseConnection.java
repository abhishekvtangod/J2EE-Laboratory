package q11;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection initializeDB(String dbName) throws ClassNotFoundException {
//		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbURL = "jdbc:mysql:/";
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUsername = "root";
		String dbPass = "";
		
		Class.forName(dbDriver);
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPass);
			System.out.println("DB connected successfully...");
		} catch(Exception e) {
			System.out.println("Couldn't connect to database...");
			System.out.println(e);
		}
		
		return con;
	}
}
