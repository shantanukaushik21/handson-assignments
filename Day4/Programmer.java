
public class Programmer extends Employee {
	public Programmer(String name, String dob, String gender, long phone, int empId, int salary) {
		super(name, dob, gender, phone,empId, salary);
		System.out.println("Programmer Created");
	}
	public void getDetails() {
		super.getDetails();
		System.out.println("Programmer");
		System.out.println("***********************************");
	}
}
