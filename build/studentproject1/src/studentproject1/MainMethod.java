package studentproject1;
import java.util.*;

public class MainMethod {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		StudentSystem ss=new StudentSystem();
		
		 ss.loadFromFile();; //Load on startup
		
		while(true) {
			System.out.println("---Student Management System");
			System.out.println("1.Add a new Student");
			System.out.println("2.Delete an existing Student");
			System.out.println("3.View all Students");
			System.out.println("4.Search a Student");
			System.out.println("5.Update specific student marks");
			System.out.println("6.Update name and course of a Student");
			System.out.println("7.Top 3 students by marks");
			System.out.println("8. Export Student Data to Text File");
			System.out.println("9.Exit");
			System.out.print("Enter your Choice: ");
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1: {
				//Adding new student
				System.out.print("Enter ID:");
				int rollNo=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name:");
				String name=sc.nextLine();
				System.out.print("Enter Course:");
				String course=sc.nextLine();
				System.out.print("Enter Marks:");
				double marks=sc.nextDouble();
				Student student=new Student(rollNo, name, course, marks);
				ss.addStudent(student);
				System.out.println("Student added successfully.");
                break;
			}
			
			case 2:{
				//Removing student from the list
				System.out.print("Enter Student ID to be removed:");
				int removestudentid=sc.nextInt();
				ss.removeStudent(removestudentid);
				break;
			}
			
			case 3:{
				//View all students in the list
				System.out.println("Student Details:");
				ss.viewAllStudents();
				break;
			}
			
			case 4:{
				//Case to search by id or name
				System.out.println("1.Search by Student Roll no");
				System.out.println("2.Search by Student name");
				System.out.println("3.Exit");
				System.out.print("Enter your choice: ");
				int ch=Integer.parseInt(sc.nextLine()); //Integer.parseInt used to directly accept Int value
				switch(ch)
				{
				case 1:{
					//Searching student from Student ID number
					System.out.print("Enter Student ID to be searched:");
					int searchstudentid=sc.nextInt();
					ss.searchStudentbyRollNo(searchstudentid);
					break;
				}
				case 2:{
					//Search by name
					System.out.print("Enter Student name to be searched:");
					String keyword=sc.nextLine();
					ss.searchStudentbyName(keyword);
					break;
				}
				case 3:{
					//Exit
					System.out.println("Exiting");
					return;					
				}
				default:System.out.println("Enter valid option");
				}
				break;
			}
			
			case 5:{
				//Update marks of a particular student
				System.out.print("Enter the student ID to update marks");
				int updateId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the student Updated marks");
				int updateMarks=sc.nextInt();
				ss.updateStudentMarks(updateId, updateMarks);
				break;
			}
			
			case 6:{
				//Update name and course of a particular student
				System.out.print("Enter student id to update details:");
				int rollNo=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Updated name:");
				String newName=sc.nextLine();
				System.out.print("Enter Updated Course:");
				String newCourse=sc.nextLine();
				ss.updateStudentDetails(rollNo, newName, newCourse);
				break;
			}
			
			case 7:{
				//Top 3 Students by highest marks
				ss.displayTop3Students();
				break;
			}
			
			case 8:{
				//Export text file
				ss.exportStudentsToTextFile("students.txt");
			    break;
			}
			
			case 9:{
				//Exit
				System.out.println("Exiting");
				ss.saveToFile();
				sc.close();
				return;
			}
			default:System.out.println("Invalid Choice");
		}
	}
	}
}
