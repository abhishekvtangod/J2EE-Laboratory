

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import q6.DBConnection;


/**
 * Servlet implementation class Q6
 */
@WebServlet("/Q6")
public class Q6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String emp_name = request.getParameter("emp_name");
		String address = request.getParameter("address");
		Date dob = Date.valueOf(request.getParameter("dob"));
		response.setContentType("text/html");
		try {
			Connection con = DBConnection.initialize("Department");
			String query1 = "INSERT INTO `Employee` (`emp_id`, `emp_name`, `address`, `dob`) VALUES (?, ?, ?, ?) ";
			PreparedStatement ps = con.prepareStatement(query1);
			ps.setInt(1, emp_id);
			ps.setString(2, emp_name);
			ps.setString(3, address);
			ps.setDate(4, dob);
			ps.execute();
		
			String query2 = "SELECT * FROM Employee";
			
			ResultSet rs = ps.executeQuery(query2);
			PrintWriter out = response.getWriter();
			while(rs.next()) {
				emp_id = rs.getInt(1);
				emp_name = rs.getString(2);
				address = rs.getString(3);
				dob = rs.getDate(4);
				String fin = "<h2>Empid, Emp Name, Address, dob : " + emp_id +", " + emp_name + ", " + address + ", " + String.valueOf(dob) + "</h2><br>";
				out.println(fin);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
