

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import q4.DBConnection;

/**
 * Servlet implementation class Police
 */
@WebServlet("/Police")
public class Police extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Police() {
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
		int n = Integer.parseInt(request.getParameter("n"));
		String s = request.getParameter("ap");
//		System.out.println(n + " " + s);
		Connection con = null;
		try {
			con = DBConnection.initialize("Police");
			if(!con.isClosed()) {
				System.out.println("Connected to DB");
			} else {
				System.out.println("Couldn't connect to DB");
			}
			Statement st = con.createStatement();
			ResultSet rs = null;
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			if(n == 1) {//area
				String query = "select phone_no from police_station where area = \"" + s + "\"";
				rs = st.executeQuery(query);
				while(rs.next()) {
					out.print("Area : " + s + ", Phone No: " + rs.getInt(1));
				}
			} else { //phone
				String query = "select area from police_station where phone_no = \"" + s + "\"";
				rs = st.executeQuery(query);
				while(rs.next()) {
					out.print("Area : " + rs.getString(1) + ", Phone No: " + s);
				}
			
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
