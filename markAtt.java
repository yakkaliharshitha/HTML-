package demo;

import java.io.IOException;
import java.io.PrintWriter;
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

import org.apache.catalina.servlet4preview.RequestDispatcher;

import com.model.Student;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet("/markAtt")
public class markAtt extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sem= request.getParameter("sem");
		 try
		 {
		 Class.forName("oracle.jdbc.OracleDriver");
		 java.sql.Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dxcfs","pass");

		 String sql="select * from student where std_sem=?";
		 PreparedStatement stat=con.prepareStatement(sql);
		         stat.setString(1, sem);
		 ResultSet rs=stat.executeQuery();
		 PrintWriter out=response.getWriter();
		 ArrayList<String> ids=new ArrayList<>();
		 String[] datas=request.getParameterValues("status");
		 while(rs.next())
		 {
		      
		 String str = "<html>";
		 str+="<bgcolour='#e03d63'>";
		 str+="<tr>";
		 str+="<center>";
		 str+="<td>"+ rs.getString("std_id") +"</td>     ";
		 out.println("   ");
		 str+="<td>"+ rs.getString("std_name") +"</td>";
		 str+="<td> <input type='checkbox' name='state' value='"+rs.getString("std_id")+"'> </td><br><br>";
		 str+="</center>";
		 str+="</tr>";
		 out.println(str);
		 ids.add(rs.getString(1));
		 ids.add(rs.getString(2));
		 ids.add(rs.getString(3));
		 ids.add(rs.getString(4));
		 ids.add(rs.getString(5));
		 ids.add(rs.getString(6));

		 }
		 String s="<html>";
		 s+="<center>";
		 s+="<form >";
         s+="<input type='submit'>";
		 s+="</form>";
		 s+="</center>";
		 out.println(s);
		 
		 ArrayList<Student> studentsAll = new ArrayList<Student>();
		 
		 Student stdd = new Student(rs.getInt("std_id"), rs.getString("std_name"), rs.getInt("std_sem"), rs.getInt("std_sem"),rs.getString("std_add"),rs.getInt("std_phno"));
		 studentsAll.add(stdd);
		 request.setAttribute("students", studentsAll);
		HttpSession session=request.getSession();
		session.setAttribute("students", studentsAll);
		//session.setAttribute("ids", ids);
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("StudentAtt.jsp");
	    dispatcher.forward(request, response);



		 }
		 catch(Exception e)
		 {

		 e.printStackTrace();
		 }

	}
}
