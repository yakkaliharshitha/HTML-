package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/markAttendance")
public class markAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sem= request.getParameter("sem");


		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dxcfs","pass");

		String sql="select * from students where std_sem=?";
		PreparedStatement stat=con.prepareStatement(sql);

		stat.setString(1, sem);
		ResultSet rs=stat.executeQuery();
		PrintWriter out=response.getWriter();
		out.print("<tr> <td> Stud Id </td> <td> Name </td>  <td> Select </td> </tr>");

		ArrayList<String> ids=new ArrayList<>();

		while(rs.next())
		{
		out.print("<tr>");
		out.print("<td>"+ rs.getString(1) +"</td>");
		out.print("<td>"+ rs.getString(2) +"</td>");
		out.print("<td> <input type='checkbox' name='status' value='"+rs.getString(1)+"'> </td>");
		out.print("</tr>");
		ids.add(rs.getString(1));

		}

		HttpSession session= request.getSession();
		session.setAttribute("ids", ids);


		}
		catch(Exception e)
		{

		e.printStackTrace();
		}



	}

	
}
