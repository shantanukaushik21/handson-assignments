
class SavingAccount {
	 int accountNo;
	 String name;
	 int balance;
	 String ifsc;
	 String city;
	 String state;
	 int pin;
	 
	 SavingAccount(int acc, String name, String city, String state){
		 this.accountNo =acc;
		 this.name= name;
		 this.city=city;
		 this.state=state;
		 this.ifsc="HSBC001";
		 this.balance=0;	 
	 }
	 SavingAccount(int acc, String name, int bal, String city, String state){
		 this.accountNo =acc;
		 this.name= name;
		 this.balance=bal;
		 this.city=city;
		 this.state=state;
		 this.ifsc="HSBC001";
		 
	 }
	 void display() {
		 System.out.println("Account no = "+accountNo);
		 System.out.println("Name = "+name);
		 System.out.println("Balance = "+balance);
		 System.out.println("ifsc = "+ifsc);
		 System.out.println("city = "+city);
		 System.out.println("state = "+state);
	 }
	 void withdraw(int amt) {
		 if(amt>this.balance) {
			 System.out.println("insufficient Balance");
		 }
		 else {
			 this.balance-=amt;
			 System.out.println("Amount withdrawn");
			 System.out.println("Your current balance is = "+this.balance);
		 }
	 }
	 void deposit(int amt) {
		 this.balance+=amt;
		 System.out.println("Amount Deposited");
		 System.out.println("Your current balance is = "+this.balance);
		 
	 }
	 
}

