package q2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	protected static Connection initializeDB(String dbName) throws ClassNotFoundException {
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/";
		String dbUser = "root";
		String dbPass = "";
		Connection con = null;
		Class.forName(dbDriver);
		try {
			con = DriverManager.getConnection(dbUrl+dbName, dbUser, dbPass);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
}
