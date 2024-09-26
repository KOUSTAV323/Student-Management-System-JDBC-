package com.jsp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jsp.model.Student;

public class StudentController {
	static Scanner sc=new Scanner(System.in);

	public void saveStudent(Student Student) 
	{
		try {
	
			Class.forName("org.postgresql.Driver");

				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/forjdbc","postgres","root");
				PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
				
				pstmt.setInt(1, Student.getId());
				
				
				pstmt.setString(2, Student.getName());
				
				
				pstmt.setString(3,Student.getEmail());
				
				pstmt.setString(4, Student.getPassword());
				
				pstmt.setString(5,Student.getDob());
				
				pstmt.setString(6,Student.getAddress());
				
				
				pstmt.setString(7,Student.getGender());
				
				pstmt.setLong(8,Student.getMob());
				
				pstmt.setString(9,Student.getRelationshipstatus());
				
				 int n=pstmt.executeUpdate();
				 System.out.println(n + "Student are saved");
				 con.close();
			} catch (SQLException  |ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
//find Student by id
	public void findStudentById(int stuId) 
	{ 
		try {
			Class.forName("org.postgresql.Driver");
		Connection		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forjdbc","postgres","root");
			PreparedStatement pstmt=con.prepareStatement("select * from student where id=?");
			pstmt.setInt(1,stuId);
			ResultSet rs=pstmt.executeQuery();
			 boolean b=rs.next();
			 if(!b)
			 {
				 System.out.println("record not found");
			 }
			 else
			 {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getLong(8)+" "+rs.getString(9));
			 }
			 con.close();
			}
            catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
			
		
	//Update Student by id	
           public void updateStudentbyid(int stuId, String newrelationship) 
           {
        	   try {
				Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forjdbc","postgres","root");
					PreparedStatement pstmt=con.prepareStatement("update student set relationship=? where id=?");
					pstmt.setString(1, newrelationship);
					pstmt.setInt(2, stuId);
					int n=pstmt.executeUpdate();
					if(n!=0) {
						System.out.println(n +"Records are Updated");
					}
					else
					{
						System.out.println("Records not found");
					}
					con.close();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }


//delete Student by Id
public void deleteStudentById(int stuId)
{
	try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forjdbc","postgres","root");
	PreparedStatement pstmt=con.prepareStatement("delete from student where id=?");
	pstmt.setInt(1, stuId);
	int n=pstmt.executeUpdate();
	if(n!=0) {
		System.out.println(n +"records are deleted");
	}
	else
	{
		System.out.println("records are not found");
	}
}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
//find all Student
public void findAllStudent()
{
	try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forjdbc","postgres","root");
	PreparedStatement pstmt=con.prepareStatement("select * from student");
	 ResultSet rs=pstmt.executeQuery();
	 boolean b=rs.next();
	 if(!b)
	 {
		System.out.println("record not found"); 
	 }
	 else {
		 do {
			 System.out.println("\n"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getLong(8)+" "+rs.getString(9));
		 }while(rs.next());
	 }
	 con.close();
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}

}
}