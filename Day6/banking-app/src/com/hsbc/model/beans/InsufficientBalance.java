package com.hsbc.model.beans;

public class InsufficientBalance extends Exception {
	public InsufficientBalance() {
		super("Balance is Insufficient");
	}

	public InsufficientBalance(String msg) {
		super(msg);
	}
}
