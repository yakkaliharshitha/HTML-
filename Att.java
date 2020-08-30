package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Student;



@WebServlet("/Att")
public class Att extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String[] datas=req.getParameterValues("status");

	PrintWriter out= resp.getWriter();
	resp.setContentType("text/html");

	HttpSession session= req.getSession();
	
	
		
	ArrayList<String> checkbox=(ArrayList<String>) session.getAttribute("checkbox");
    ArrayList <String> stdd=(ArrayList<String>)session.getAttribute("checkbox");
	out.print("Students Present are as follows <br>");
	
	for(String data:datas) {
	out.print(data+"<br>");
	}

	out.print("---------------------------------------------------------- <br>");

	out.print(" All Students are as follows <br>");
	for(String std:checkbox) {
	out.print(std+"<br>");
	}
	
	
	out.print("---------------------------------------------------------- <br>");
	
	ArrayList <String> fll=(ArrayList<String>)session.getAttribute("checkbox");
	
	out.print(!(datas.equals(stdd)));
	fll.addAll(stdd);
	
	out.print("Students Absent are as follows<br>");
	for(String fl:fll) {
	out.print(fl+"<br>");
	
	out.print("---------------------------------------------------------- <br>");
	}
	

	}

		



	}

	


