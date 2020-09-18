
public class Employee extends People {
	int empId;
	int salary;
	//Account account;
	public Employee(String name, String dob, String gender, long phone, int empId, int salary) {
		super(name, dob, gender, phone);
		this.salary=salary;
		this.empId=empId;
	}
	public Employee(String name, String dob, String gender, long phone) {
		super(name, dob, gender, phone);
	}
	
	
	public void incrementSalary() {
		this.salary+=(this.salary*10)/100;
	}
	public void updateBalance(int amount) {
		this.salary=amount;
	}
	public void getDetails() {
		super.getDetails();
		//System.out.println("This is an Employee ");
		System.out.println("Emp id: "+empId+" salary = "+salary);
		System.out.println("----------------------------------------");
		
	}
	
}
