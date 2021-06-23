<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action = "Grade.jsp" name = "Grade">
		<input name = "sub1" placeholder = "sub1">
		<input name = "sub2" placeholder = "sub2">
		<input name = "sub3" placeholder = "sub3">
		<input name = "sub4" placeholder = "sub4">
		<input name = "sub5" placeholder = "sub5">
		
		<input type = "submit" name = "submit" value = "submit" >
		
	</form>

	<%
		if(request.getParameter("submit") != null){
			int sub1 = Integer.parseInt(request.getParameter("sub1"));
			int sub2 = Integer.parseInt(request.getParameter("sub2"));
			int sub3 = Integer.parseInt(request.getParameter("sub3"));
			int sub4 = Integer.parseInt(request.getParameter("sub4"));
			int sub5 = Integer.parseInt(request.getParameter("sub5"));
			int sum = sub1 + sub2 + sub3 + sub4 + sub5;
			double avg = sum / 5.0;
			
			String grade = null;
			if(avg >= 90){
				grade = "S";
			} else if (avg >= 80){
				grade = "A";
			} else if (avg >= 70){
				grade = "B";
			} else if (avg >= 60){
				grade = "C";
			} else if (avg >= 50){
				grade = "D";
			} else {
				grade = "Fail";
			} 
			
			
			
			out.print("<h1>" + grade + "</h1>");
		}
	
	%>


</body>
</html>