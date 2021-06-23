<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="movie.jsp" method = "post">
		<input type = "text" placeholder = "name" name = "name">
		<input type = "number" placeholder = "age" name = "age" >
		<input type = "submit" name = "submit_btn">
	</form>

	<%
		if(request.getParameter("submit_btn") != null){
			int price;
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			if(age > 62){
				price = 50;
			} else if(age < 10){
				price = 30;
			} else{
				price = 80;
			}
			out.print("Name : " + name + ", Age: " + age + ", Price: " + price);
			
			
		}
	
	%>
	
</body>
</html>