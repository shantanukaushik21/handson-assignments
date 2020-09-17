public class MainBank {
    public static void main(String[] args) {
    	
    	
    	
    	//First Requirement
    	
//    	Long accountNo=Long.parseLong(args[0]);
//    	double amount=Long.parseLong(args[1]);
    	
//    	Account tempAccount=getAccount(accountNo);
//    	System.out.println("------------------Bank info before deposit---------------");
//    	tempAccount.accountInformation();
//    	tempAccount.deposit(amount);
//    	System.out.println("------------------Bank info after deposit---------------");
//    	tempAccount.accountInformation();
//    	// update in the database
//    	Account[] accounts = AccountsDB.getAccounts();
//    	for(Account acc : accounts) {
//    		if(accountNo==acc.getAccountNumber()) {
//    			acc.setBalance(tempAccount.getBalance());
//    		}
//    	}
//    	System.out.println("Database updated with the new account");
    	
    	//Database updated with the new account
    	
    	//Second Requirment
    	
    	Long sourceAccountNo=Long.parseLong(args[0]);
    	Long destinationAccountNo=Long.parseLong(args[1]);
    	double amount= Double.parseDouble(args[2]);
    	
    	Account sourceAccount=getAccount(sourceAccountNo);
    	Account destinationAccount=getAccount(destinationAccountNo);
    	if(sourceAccount!=null && destinationAccount!=null) {
    		
    		System.out.println("---------------Before Transaction----------------");
    		System.out.println("Source Account Details");
    		sourceAccount.accountInformation();
    		System.out.println("Destination Account Details");
    		destinationAccount.accountInformation();
    		
    		if(sourceAccount.getBalance()>=amount) {
    			sourceAccount.withdraw(amount);
    			destinationAccount.deposit(amount);
    		}else {
    			System.out.println("insufficient Funds in the Source account");
    		}
    	
    		System.out.println("---------------After Transaction----------------");
    		sourceAccount.accountInformation();
    		destinationAccount.accountInformation();
    		UpdateDB(sourceAccount);
    		UpdateDB(destinationAccount);
    		
    	}else {
    		System.out.println("Account details not available");
    	}
    	
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
        //System.out.println("Account no. invalid");
        return null;
        // get the account from accounts using the accountNo

    }
    
    // to update the DB
    //Update code will only work for dynamic DB not in this case
    public static void UpdateDB(Account account) {
    	Account[] accounts = AccountsDB.getAccounts();
    	for(int i=0;i<accounts.length;i++) {
    		Account acc=accounts[i];
    		if(acc.getBalance()!=account.getBalance()) {
    			accounts[i]=account;
    		}
    	}
    	
    }
}