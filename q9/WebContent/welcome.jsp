<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		if(user.equals("abhi") && pass.equals("1234")){
			System.out.println("Welcome " + user);
			session.setAttribute("user", user);
			//request.getRequestDispatcher("hello.jsp").forward(request, response);
			response.sendRedirect("hello.jsp");
			
		} else{
			System.out.println("Not valid");
			response.sendRedirect("register.html");
		}
	
	%>
</body>
</html>