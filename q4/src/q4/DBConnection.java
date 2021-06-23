package q4;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection initialize(String dbName) throws ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbUser = "root";
		String dbPass = "";
		
		Class.forName(dbDriver);
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbURL + dbName, dbUser, dbPass);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
}
