package com.jsp.view;

import java.util.Scanner;
import com.jsp.controller.StudentController;

import com.jsp.model.Student;

public class StudentView
{
static Scanner sc=new Scanner(System.in);
	private static Student getStudentObject()
	{
		System.out.println("ENTER STUDENT ID");
		int id=sc.nextInt();
		System.out.println("ENTER STUDENT NAME");
		sc.nextLine();
		String name=sc.nextLine();
		 // Dummy
		System.out.println("ENTER STUDENT EMAIL");
		String email=sc.nextLine();
		System.out.println("ENTER STUDENT PASSWORD");
		String password=sc.nextLine();
		System.out.println("ENTER STUDENT DOB");
		String dob=sc.nextLine();
		System.out.println("ENTER STUDENT ADDRESS");
		String address=sc.nextLine();
		System.out.println("ENTER STUDENT GENDER");
		String gender=sc.nextLine();
		System.out.println("ENTER STUDENT MOB");
		long mob=sc.nextLong();
		System.out.println("ENTER STUDENT RELATIONSHIP");
		sc.nextLine();
		String relationship=sc.nextLine();
		//sc.nextLine(); // Dummy
		
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setDob(dob);
		s.setAddress(address);
		s.setGender(gender);
		s.setMob(mob);
		s.setRelationshipstatus(relationship);
		
		return s;
	}
	public static void main(String[] args)
	{
		
	System.out.println("WELCOME TO SMS APP");
	StudentController controller=new StudentController();
	
	while(true)
	{
	System.out.println("ENTER YOUR CHOICE");
	System.out.println("1.SAVE STUDENT");
	System.out.println("2.FIND STUDENT BY ID");
	System.out.println("3.UPDATE STUDENT BY ID");
	System.out.println("4.DELETE STUDENT BY ID");
	System.out.println("5.FIND ALL");
	System.out.println("6.EXIT");
	
	int choice=sc.nextInt();
	
	switch(choice) {
	case 1:
		Student s=getStudentObject();//create student object and return 
		controller.saveStudent(s);
		break;
		
	case 2:
	{
		System.out.println("ENTER STUDENT ID");
		int stuId=sc.nextInt();
		controller.findStudentById(stuId);
		break;
	}

		
	case 3:
	{
		System.out.println("Enter Student ID Which You WAnt to Update");
		int stuId = sc.nextInt();
		System.out.println("Enter new RelationshipStatus");
		sc.nextLine();
		String newRelationShipStatus=sc.nextLine();
		controller.updateStudentbyid(stuId,newRelationShipStatus);
	}
	break;
	case 4:
		System.out.println("Enter student id");
		int stuid2 = sc.nextInt();
		controller.deleteStudentById(stuid2);
		break;
	case 5:
		controller.findAllStudent();
		break;
		
		
		
		
	case 6:
		System.out.println("thank you");
		return;
		
		default:
			System.out.println("invaild choice");
			break;
		
	}
	}
	
	}

	}
