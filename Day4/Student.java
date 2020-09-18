
public class Student extends People {
	String grade;
	Student(String name, String dob, String gender, long phone, String grade){
		super(name, dob, gender, phone);
		this.grade=grade;
		System.out.println("Student profile created");
	}
	public void updateGrade(String grade) {
		this.grade=grade;
		System.out.println("--------Grade Updated---------");
	}
	public void getDetails() {
		super.getDetails();
		System.out.println("Grade : "+ grade);
	}
}
