

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Q7
 */
@WebServlet("/Q7")
public class Q7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q7() {
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
//		sub_id sub_name, fac_id
		response.setContentType("text/html");
		int sub_id = Integer.parseInt(request.getParameter("sub_id"));
		String sub_name = request.getParameter("sub_name");
		int fac_id = Integer.parseInt(request.getParameter("fac_id"));
		
		System.out.println(sub_id + " " + sub_name + " " + fac_id);
		
		try {
			Connection con = q7.DBConnection.initialize("Department");
			String query1 = "UPDATE `Subject` SET `sub_id`= ? ,`sub_name` = ? WHERE fac_id = ? ";
			PreparedStatement ps = con.prepareStatement(query1);
			ps.setInt(1, sub_id);
			ps.setString(2, sub_name);
			ps.setInt(3, fac_id);
			ps.execute();
			String query2 = "select * from Subject";
			ResultSet rs = ps.executeQuery(query2);
			PrintWriter out = response.getWriter();
			while(rs.next()) {
				sub_id = rs.getInt(1);
				sub_name = rs.getString(2);
				fac_id = rs.getInt(3);
				String fin = "<h2>sub_id, sub_name, fac_id: " + sub_id + ", " + sub_name + ", " + fac_id + "</h2><br>";
				out.println(fin);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
