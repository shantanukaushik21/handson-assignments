package com.hsbc.controller;

import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

import java.util.Scanner;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.*;
import com.hsbc.model.service.*;

public class MainViewController {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		AccountService service= (AccountService)UserFactory.getInstance(Type.SERVICE);
		int option=0;
		System.out.println("******************************************************************");
		System.out.println("1: Store 2: Fetch all Accounts 3: Fetch Account by Id 4: Transfer");
		System.out.println("*******************************************************************");
		
		option=scanner.nextInt();
		switch(option){
		case 1: 
			Account account=new Account();
			System.out.println("Enter the Account number");
			account.setAccountNumber(scanner.nextInt());
			System.out.println("Enter the name");
			account.setCustomerName(scanner.next());
			System.out.println("Enter the Balance");
			account.setBalance(scanner.nextDouble());
			System.out.println("Enter the contact number");
			account.setContactNumber(scanner.nextLong());
			
			service.createAccount(account);
			System.out.println("Account created with an account Number: "+account.getAccountNumber());
			break;
		case 2:
			Account[] account2=service.getAccounts();
			for(Account acc: account2) {
				System.out.println(acc);
			}
			break;
		case 3:
			
			System.out.println("Enter the Account Number");
			try {
				Account account3=service.getAccountById(scanner.nextInt());
				System.out.println(account3);
			} catch (AccountNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("ERROR:"+e.getMessage());
			}
			break;
		case 4: 
			System.out.println("Enter the Source Account Number");
//			try {
//				Account source=service.getAccountById(scanner.nextInt());
//				System.out.println("Enter the destination Account Number");
//				Account destination=service.getAccountById(scanner.nextInt());
//			} catch (AccountNotFoundException e) {
//				// TODO Auto-generated catch block
//				System.err.println("ERROR:"+e.getMessage());
//			}
			int from=scanner.nextInt();
			System.out.println("Enter the destination Account Number");
			int to=scanner.nextInt();
			System.out.println("Enter the amount");
			double amount=scanner.nextDouble();
			try {
				service.transfer(from, to, amount);
			} catch (AccountNotFoundException | InsufficientBalance e) {
				// TODO Auto-generated catch block
				System.err.println("ERROR:"+e.getMessage());
			}
			System.out.println("Ammount transfered");
			
		}
		
		
	}
}
