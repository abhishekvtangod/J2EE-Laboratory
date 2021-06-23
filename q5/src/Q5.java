

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Q5
 */
@WebServlet("/Q5")
public class Q5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q5() {
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
		String fullName = request.getParameter("fullName");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = initials(fullName);
		out.println(name);
		
	}
	private String initials(String fullName) {
		String[] name = fullName.trim().split("\s");
		String initial = "" ;
		for(String i : name) {
//			initial += String.valueOf(i.charAt(0));
			initial += i.charAt(0);
		}		
		return initial.toUpperCase();
	}
}
