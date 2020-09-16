
public class EmpDemo {

	public static void main(String[] args) {
		Employee[] empArr=new Employee[5];
		empArr[0]=new Employee(10000,"shantanu", 60000, new Address("hsp","punjab",146001));
		empArr[1]=new Employee(11000,"rahul", 40000,null);
		empArr[2]=new Employee(12000,"Archit", 10000,null);
		empArr[3]=new Employee(13000,"sakshi", 90000, new Address("delhi","delhi",12098));
		empArr[4]=new Employee(14000,"Ankit", 30000,null);
		
		for(Employee emp : empArr){
			if(emp.salary>50000) {
				emp.display();
			}
		}
		for(Employee emp : empArr){
			if(emp.address !=null) {
				emp.display();
			}
		}
		
	}

}
