package q1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class q1 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String dbName = "Department";
		try {
			Connection con = DBConnection.initialize(dbName);
			String query1 = "SELECT no_of_emp FROM `department` WHERE name = \"CSE\"\n";
			String query2 = "SELECT name, dept_id FROM `department` WHERE year_established = 2010";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			System.out.println("No of employees in CSE dept: ");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
			rs = st.executeQuery(query2);
			System.out.println("Name, Dept_id established in the year 2010");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "," + rs.getInt(2));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
