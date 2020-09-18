
public class Manager extends Employee{
	public Manager(String name, String dob, String gender, long phone, int empId, int salary) {
		super(name, dob, gender, phone,empId, salary);
		System.out.println("Manager Created");
	}
	public void getDetails() {
		super.getDetails();
		System.out.println("Manager");
		System.out.println("***********************************");
	}
}
