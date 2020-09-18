
public class Account {
	private int balance;
	private long accountNo;
	public Account(long accountNo, int balance) {
		this.accountNo=accountNo;
		this.balance=balance;
	}
	public long getAccountNo() {
		return this.accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int amount) {
		this.balance=amount;
	}
}
