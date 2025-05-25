package studentproject1;
import java.io.Serializable;

public class Student implements Serializable{
	private int rollNo;
	private String name;
	private String course;
	private double marks;
	
	public Student(int rollNo,String name,String course,double marks)
	{
		this.rollNo=rollNo;
		this.name=name;
		this.course=course;
		this.marks=marks;
	}
	
	public int getrollNo() { return rollNo;}
	
	public void setrollno(int rollno) { this.rollNo=rollno;}
	
	public String getname() {return name;}
	
	public void setname(String name) { this.name=name;}
	
	public String getcourse() {return course;}
	
	public void setcourse(String course) { this.course=course;}
	
	public double getmarks() { return marks;}
	
	public void setmarks(double marks) { this.marks=marks;}
	
	public String toString() {
		return "Student RollNo:" +rollNo+ ", Name:" +name+ ", Course:" +course+ ",Marks:" +marks;
	}
}
