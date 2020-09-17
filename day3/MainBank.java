public class MainBank {
    public static void main(String[] args) {
    	
    	Long accountNo=Long.parseLong(args[0]);
    	double amount=Long.parseLong(args[1]);
    	
    	//First Requirement
    	
    	Account tempAccount=getAccount(accountNo);
    	System.out.println("------------------Bank info before deposit---------------");
    	tempAccount.accountInformation();
    	tempAccount.deposit(amount);
    	System.out.println("------------------Bank info after deposit---------------");
    	tempAccount.accountInformation();
    	// update in the database
    	Account[] accounts = AccountsDB.getAccounts();
    	for(Account acc : accounts) {
    		if(accountNo==acc.getAccountNumber()) {
    			acc.setBalance(tempAccount.getBalance());
    		}
    	}
    	System.out.println("Database updated with the new account");
    	//Database updated with the new account
    	
    	
    	
        //pass the accountNo and amount to deposit from CLA
        //get the Account using the accountNo by calling getAccount(...)
        // if accountNo is wrong show the error message and must not perform any below
        // operation
        
        // show the account information before deposit
        //deposit the amount to that particular Account
        //show the account information after deposit
    	
    }

    // pass the accountNO and get the Account from Accounts[] 
    public static Account getAccount(long accountNo) {
        Account[] accounts = AccountsDB.getAccounts();
        	for(Account acc : accounts) {
        		if(accountNo==acc.getAccountNumber()) {
        			return acc;
        		}
        	}
        System.out.println("Account no. invalid");
        return null;
        // get the account from accounts using the accountNo

    }
}