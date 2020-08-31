package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Attendance;
import com.model.Student;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class StudentDao {
	
    public static int StudentAtt(Attendance att)throws SQLException {
        ArrayList<Student> listStudent = new ArrayList<>();
        int noOfStuds = 0;

    try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dxcfs", "pass")) {
        String sql = "insert into attendance(stud_Name,stud_id,stud_sem,stud_date,stud_att) values(?,?,?,?,?)";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1, att.getStdname());
        psmt.setInt(2, att.getStdid());
        psmt.setInt(3, att.getStdsem());
        psmt.setDate(4,   att.getDatee());
        psmt.setNString(5, att.getAtt());
        
        noOfStuds = psmt.executeUpdate();
         
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw ex;
    }      
     
    
	return noOfStuds;
}

}



