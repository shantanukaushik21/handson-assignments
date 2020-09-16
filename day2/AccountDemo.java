
public class AccountDemo {
	public static void main(String[] args) {
		SavingAccount user1=new SavingAccount(1234556, "Karan", "Delhi", "New Delhi");
		user1.display();
		user1.deposit(50000);
		user1.withdraw(500);
		user1.display();
	}
	
}
