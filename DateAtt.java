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

@WebServlet("/DateAtt")
public class DateAtt extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date= request.getParameter("date");

        try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dxcfs","pass");

		String sql="select * from attendance where stud_date=?";
		PreparedStatement stat=con.prepareStatement(sql);
        stat.setString(1, date);
		ResultSet rs=stat.executeQuery();
		
		PrintWriter out=response.getWriter();
		ArrayList<String> datebox=new ArrayList<String>();
		
		}
		catch(Exception e)
		{

		e.printStackTrace();
		}

		
	}

}
