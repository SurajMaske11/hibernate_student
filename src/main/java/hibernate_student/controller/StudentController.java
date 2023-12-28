package hibernate_student.controller;

import java.util.Scanner;

import hibernate_student.dao.StudentDao;
import hibernate_student.dto.Student;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Student student=new Student();
		StudentDao dao=new StudentDao();
		
		System.out.println("Enter the choice \n1.Save Student \n2.Update the data \n3.Delete the data \n4.Fetch the Student \n5.Get all Student data \n6.Find Student by phone \n7.Find Student by email");
		int choice=scanner.nextInt();
		
		switch (choice) {
		case 1:{
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			System.out.println("Enter the name");
			String name=scanner.next();
			System.out.println("Enter the marks");
			int marks=scanner.nextInt();
			System.out.println("Enter the phone");
			long phone=scanner.nextLong();
			System.out.println("Enter the address");
			String address=scanner.next();
			System.out.println("Enter the email");
			String email=scanner.next();
			
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setPhone(phone);
			student.setAddress(address);
			student.setEmail(email);
			
			dao.saveStudent(student);
			
			
		}
		break;
		
		case 2:{
			//Update Operation
			
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			System.out.println("Enter the name");
			String name=scanner.next();
			System.out.println("Enter the marks");
			int marks=scanner.nextInt();
			System.out.println("Enter the phone");
			long phone=scanner.nextLong();
			System.out.println("Enter the address");
			String address=scanner.next();
			System.out.println("Enter the email");
			String email=scanner.next();
			
			
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setPhone(phone);
			student.setAddress(address);
			student.setEmail(email);
			
			dao.updateStudent(student);
//			System.out.println("Update the data");
		}
		break;
		
		case 3:{
//			Delete operation 
			System.out.println("Enter the id to Delete");
			int id=scanner.nextInt();
			dao.deleteStudent(id);
			
//			System.out.println("Delete Operation");
		}
		break;
		
		case 4:{
//			Fetch data using id
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			dao.fetchStudent(id);
			
			
//			System.out.println("Fetching the data using Id");
		}
		break;
		case 5:{
			dao.getAllStudents();
		}
		break;
		
		case 6:{
			System.out.println("Enter the phone number");
			long phone=scanner.nextLong();
			dao.getStudent(phone);
		}
		break;
        
		case 7:{
			System.out.println("Enter the email");
			String email=scanner.next();
			dao.getStudent(email);
		}
		break;
		default:{
			System.out.println("Choose correct option");
		}
			
		}
		
		
	}

}
