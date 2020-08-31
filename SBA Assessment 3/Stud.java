package demo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.model.Attendance;
import com.model.Student;
import com.sun.jndi.cosnaming.IiopUrl.Address;

@WebServlet("/Stud")
public class Stud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ArrayList<Student> studentsAll = null;
      
		
		Attendance ad = null;
		long d = System.currentTimeMillis();
		Date date = new Date(d);
		
		String[] names = request.getParameterValues("state");
		HttpSession session = request.getSession();
		if(session != null) {
			studentsAll = (ArrayList) session.getAttribute("students");
		}
		for(String n : names) {
			int sids = Integer.parseInt(n);
			for(Student s : studentsAll) {
				
				if(s.getStdid() == sids) {
					ad= new Attendance(s.getStdname(), s.getStdid(), s.getStdsem(),  date, "PRESENT");
				}
				
				else {
					ad = new Attendance( s.getStdname(), s.getStdid(), s.getStdsem(),  date, "ABSENT");
				}
				
				try {
					StudentDao.StudentAtt(ad);
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("Attd.jsp");
		rd.forward(request, response);
		
		

	}

	
	

}
