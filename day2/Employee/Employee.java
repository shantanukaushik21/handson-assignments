
public class Employee {
	int id;
	String name;
	int salary;
	Address address;
	Employee(int id, String name, int salary){
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	Employee(int id, String name, int salary, Address add){
		this(id, name, salary);
		this.address=add;
	}
	void display() {
		System.out.println("name = "+this.name);
		System.out.println("id = "+this.id);
		System.out.println("salary = "+this.salary);
		if(address!=null) {
			System.out.println("Address = "+ address.city+ " "+ address.state+" "+address.pincode);
		}else {
			System.out.println("Address not Available");
		}
		
		
		
		System.out.println("----------------------------");
		
	}
}
