
public class Customer extends People {
	Account account;
	Customer(String name, String dob, String gender, long phone, long accountNo, int balance){
		super(name, dob, gender,phone);
		account=new Account(accountNo, balance);
		
		System.out.println("Customer profile created");
	}
	public void getDetails() {
		super.getDetails();
		System.out.println("This is a Customer");
		System.out.println("Customer account number : "+ account.getAccountNo());
		System.out.println("Customer account balance : "+ account.getBalance());
		System.out.println("*******************************************************");
	}
	public void updateBalance(int amount) {
		account.setBalance(amount);
		System.out.println("Balance Updated");
	}
	
}
