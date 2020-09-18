
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
}
