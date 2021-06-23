package q2;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;



public class q2 {
	public static void main (String args[]) {
		String dbName = "Department";
		try {
			Connection con = DBConnection.initializeDB(dbName);
			String query1 = "SELECT * FROM `Student` WHERE cgpa < 9";
			String query3 = "Select * from Student";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			while(rs.next()) {
				int usn = rs.getInt(1);
				String name = rs.getString(2);
				double cgpa = rs.getDouble(3);
				System.out.println("USN, NAME, CGPA : " + usn + ", " + name + ", " + cgpa);
			}
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query3);
			System.out.println("Updated");
			while(rs.next()) {
				if(rs.getString(2).equals("John")){
					rs.updateDouble(3, 8.9);
					rs.updateRow();
				}
				int usn = rs.getInt(1);
				String name = rs.getString(2);
				double cgpa = rs.getDouble(3);
				System.out.println("USN, NAME, CGPA : " + usn + ", " + name + ", " + cgpa);
				
			}
			
			
			
			
//			rs = st.executeQuery(query3);
//			System.out.println("After update: ");
//			while(rs.next()) {
//				int usn = rs.getInt(1);
//				String name = rs.getString(2);
//				double cgpa = rs.getDouble(3);
//				System.out.println("USN, NAME, CGPA : " + usn + ", " + name + ", " + cgpa);
//			}
//			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
