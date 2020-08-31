<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter the Date Here</title>
</head>
<body>
<center>
<h1>Check the Attendance</h1>

<br>
<br>
 Select Semester:<select name="sem">
<option value="1"> semester 1 </option>
<option value="2"> semester 2 </option>
<option value="3"> semester 3 </option>
<option value="4"> semester 4 </option>
<option value="5"> semester 5 </option>
<option value="6"> semester 6 </option>
</select>

<br>
<br>
<form  action="DateAtt">

Enter Date<input type="Date" name="date" max="2020-08-29">
<br>
<br>
<input type="submit" value="Check attendance by date">
</form>
</center>

</body>
</html>