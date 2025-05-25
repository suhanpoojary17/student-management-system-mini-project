package studentproject1;
import java.util.*;
import java.io.*;
public class StudentSystem {
	Map<Integer, Student> studentMap=new HashMap<>();
	private final String filenameString="studentsproject1.ser";
	
	//Save to File
	public void saveToFile() {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filenameString))) {
			oos.writeObject(studentMap);
			System.out.println("Details saved to File");
		}catch(IOException e) {
			System.out.println("Error Saving Details"+e.getMessage());
		}
	}
	
	//Load from FIle
	public void loadFromFile() {
		File file=new File(filenameString);
		if(!file.exists()) return;
		
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filenameString))){
			studentMap= (HashMap<Integer, Student>) ois.readObject();
			System.out.println("Details loaded");
		}
		catch(IOException | ClassNotFoundException e)
		{
			System.out.println("Error Loading Details"+e.getMessage());
		}
	}
	
	//Adding Student
	public void addStudent(Student student) {
		studentMap.put(student.getrollNo(), student);
	}
	
	//Removing with rollNo
	public void removeStudent(int rollno) {
		if(studentMap.containsKey(rollno))
		{
			studentMap.remove(rollno);
			System.out.println("Student removed Successfully");
		}else {
			System.out.println("Student not found to Remove");
		}
	}
	
	//View all students
	public void viewAllStudents() {
		if(studentMap.isEmpty())
		{
			System.out.println("No Students to Display");
		}else {
			List<Student> list = new ArrayList<>(studentMap.values());
	        list.sort(Comparator.comparing(Student::getrollNo)); // 👈 Sorting here

	        for (Student s : list) {
	            System.out.println(s);
		}
	}
	}
	
	//Search by rollNo
	public void searchStudentbyRollNo(int rollNo) {
		Student student=studentMap.get(rollNo);
		if(student!=null)
			System.out.println(student);
		else
			System.out.println("Student not found");
	}
	
	//Search by name
	public void searchStudentbyName(String keyword) {
		boolean found=false;
		for(Student s:studentMap.values()) {
			if(s.getname().toLowerCase().contains(keyword.toLowerCase())) {
				System.out.println(s);
				found=true;
			}
		}
		if(!found) {
			System.out.println("No Student with name containing: " +keyword);
		}
	}
	
	//Update Student Marks
	public void updateStudentMarks(int rollNo,double newMarks) {
		Student student=studentMap.get(rollNo);
		if(student!=null)
		{
			student.setmarks(newMarks);
			System.out.println("Marks updated Successfully");
		}
		else {
			System.out.println("Student not Found");
		}
	}

	//Update name and course of a student with regno
	public void updateStudentDetails(int rollNo,String newName,String newCourse)
	{
		Student student=studentMap.get(rollNo);
		if(student!=null) {
			student.setname(newName);
			student.setcourse(newCourse);
			System.out.println("Name and Course Set Successfully");
		}else {
			System.out.println("No Student with the register number found.Unsuccessful");
		}
	}
	
	//Top3 Students based on marks
	public void displayTop3Students() {
		List<Student> list = new ArrayList<>(studentMap.values());
		
		list.sort((s1,s2)->Double.compare(s2.getmarks(), s1.getmarks()));
		
		System.out.println("Top 3 Students by Marks:");
		for(int i=0;i<Math.min(3, list.size());i++)
		{
			System.out.println(list.get(i));
		}
	}
	
	//export details text file
	public void exportStudentsToTextFile(String filename) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
	        for (Student student : studentMap.values()) {
	            writer.println("Roll No: " + student.getrollNo() +
	                           ", Name: " + student.getname() +
	                           ", Course: " + student.getcourse() +
	                           ", Marks: " + student.getmarks());
	        }
	        System.out.println("✅ Student data exported to " + filename);
	    } catch (IOException e) {
	        System.out.println("❌ Error exporting data: " + e.getMessage());
	    }
	}

	
}
