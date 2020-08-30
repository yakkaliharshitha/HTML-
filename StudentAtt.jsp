<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Stud" >
		<table cellspacing="5" cellpadding="0">

			<c:forEach var="students" items="${studentsAll}">
				<tr>
					<td>${studentsAll.stdid}</td>
					<td>${studentsAll.stdname}</td>
					<td></td>
					<td><input type='checkbox' name='state' value='${studentsAll.stdid}'></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="SUBMIT">
	</form>


</body>
</html>