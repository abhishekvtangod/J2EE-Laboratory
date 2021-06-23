import java.util.*;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class Q2 {
	String url = "jdbc:mysql://locaalhost://3306/";
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "";
	String password = "";
	String userName = "root";
	Connection conn = null;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url+dbName,userName,password);
		conn.setAutoCommit(false);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("(1 - Insert, 2- display , 3 - Transact)");
			int opt = sc.nextInt();
			
			switch(opt) {
			case 1: 
				System.out.println("Insert id, name,balance");
				String id = sc.next();
				String name = sc.next();
				Double balance = sc.nextDouble() ;
				
				String query = "INSERT INTO bank VALUES(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1,id);
				ps.setString(2,name);
				ps.setDouble(3,balance);
				
				System.out.println("Added");
				break;
				
			case 2 :
				Statement st = conn.createStatement();
				String sql = "SELECT * FROM bank";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					 id = rs.getString(1);
					 name = rs.getString(2);
					 balance = rs.getDouble(3);
					
					System.out.println(id + " " + name + " "+ balance);
					break;
					
				}
				case 3 :
					System.out.println("id");
					id = sc.next();
					System.out.println("1 - D 2 - W");
					int opt2 = sc.nextInt();
					switch(opt2) {
						case 1 : 
							System.out.println("amt");
							Double amt = sc.nextDouble();
							Savepoint sv1 = conn.setSavepoint();
							String q1 = "update bank set balance = balance + ? where id = ?";
							PreparedStatement ps1 = conn.prepareStatement(q1);
							ps1.setDouble(1, amt);
							ps1.setString(2,id);
							
							int cnt = ps1.executeUpdate();
							
							conn.commit();
							
							break;
						case 2 :
							System.out.println("amt");
							amt = sc.nextDouble();
							Savepoint sv2 = conn.setSavepoint();
							String q2 = "update bank set balance = balance - ? where id = ?";
							PreparedStatement ps2 = conn.prepareStatement(q2);
							ps2.setDouble(1, amt);
							ps2.setString(2,id);
							
							String q3 = "SELECT balance from bank where id = "+ "'" + id + "'";
							cnt = ps2.executeUpdate();
							ResultSet rs1 = ps2.executeQuery(q3);
							rs1.next();
							if(rs1.getDouble(1) < 0) {
								System.out.println("Rollback");;
								conn.rollback(sv2);
								
							}
							
							conn.commit();
							conn.releaseSavepoint(sv2);
					}
				
				
			}
			
		}
	}
	catch(Exception e) {
		conn.rollback();
		e.printStackTrace();
	}
}
