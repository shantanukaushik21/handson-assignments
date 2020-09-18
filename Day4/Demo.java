
public class Demo {
	public static void main(String[] args) {
		Manager manager1 =new Manager("shantanu","01/01/1998","Male",97384991733L, 10000, 50000);
		Programmer programmer1=new Programmer("rahul","04/05/1997","Male",7384991733L, 11000, 30000);
		Admin admin1 =new Admin("Sakshi","08/04/1997","Female",7384991733L, 11000, 30000);
		Customer customer1=new Customer("karan","06/04/1998","Male",973849913L,9992324559L,40000);
		Student student1=new Student("ojasva","02/07/1998","Male",973849913L,"B");
		manager1.getDetails();
//		programmer1.getDetails();
//		admin1.getDetails();
//		
		System.out.println();
		
		customer1.getDetails();
		customer1.updateBalance(9000);
		customer1.getDetails();
		
		System.out.println();
		
		student1.getDetails();
		student1.updateGrade("A");
		student1.getDetails();
		
	}
	
	public static void display(People person) {
		if(person instanceof Manager) {
			Manager manager =(Manager)person;
			manager.getDetails();
		}
		if(person instanceof Programmer) {
			Programmer programmer =(Programmer)person;
			programmer.getDetails();
		}
		if(person instanceof Admin) {
			Admin admin =(Admin)person;
			admin.getDetails();
		}
		if(person instanceof Customer) {
			Customer customer=(Customer) person;
			customer.getDetails();
		}
		if(person instanceof Student) {
			Student student=(Student) person;
			student.getDetails();
		}
		
	}
	public static void testUpdate(People person) {
			
			if(person instanceof Manager) {
				
				int bonus=15000;
				Manager manager =(Manager)person;
				manager.incrementSalary();
				int newSalary=manager.getSalary()+bonus;
				manager.updateSalary(newSalary);
				manager.getDetails();
				
			}
			if(person instanceof Programmer) {
				
				int bonus=10000;
				Programmer programmer =(Programmer)person;
				programmer.incrementSalary();
				int newSalary=programmer.getSalary()+bonus;
				programmer.updateSalary(newSalary);
				programmer.getDetails();
				
			}
			if(person instanceof Admin) {
				
				int bonus=10000;
				Admin admin =(Admin)person;
				admin.incrementSalary();
				int newSalary=admin.getSalary()+bonus;
				admin.updateSalary(newSalary);
				admin.getDetails();
				
			}
			if(person instanceof Customer) {
				
				int balance=10000;
				Customer customer =(Customer)person;
				customer.updateBalance(balance);
				customer.getDetails();
				
			}
		}
}
