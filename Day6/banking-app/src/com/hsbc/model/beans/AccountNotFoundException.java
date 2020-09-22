package com.hsbc.model.beans;

// Add constructors inside AccountNotFoundException
public class AccountNotFoundException extends Exception {
	AccountNotFoundException(){
		super("Account not found");
	}
	public AccountNotFoundException(String msg){
		super(msg);
	}
}
