package com.hsbc.model.service;

import com.hsbc.model.beans.Account;
import com.hsbc.model.beans.AccountNotFoundException;
import com.hsbc.model.beans.InsufficientBalance;
import com.hsbc.model.beans.*;
import com.hsbc.model.dao.*;
import com.hsbc.model.utility.*;

public class AccountServiceImpl implements AccountService{
	
	AccountDao dao;
	public AccountServiceImpl(){
		dao=(AccountDao)UserFactory.getInstance(Type.DAO);
	}

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Account accountCreated=dao.store(account);
		return accountCreated;
		
	}

	@Override
	public Account getAccountById(int accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		if(dao.fetchAccountById(accountNumber)==null) {
			throw new AccountNotFoundException ("Sorry Account with Account Number "+accountNumber+" not found");
		}
		return dao.fetchAccountById(accountNumber);
		
	}
	
	@Override
	public Account[] getAccounts() {
		Account[] newArray=dao.fetchAccouts();
		return newArray;
	}

	@Override
	public void transfer(int from, int to, double amount) throws AccountNotFoundException, InsufficientBalance {
		// TODO Auto-generated method stub
		Account source= getAccountById(from);
		if(source.getBalance()<amount) {
			throw new InsufficientBalance("Source Account "+from+"Do not have Sufficinet Balance");
		}
		source.setBalance(source.getBalance()-amount);
		source=dao.updateAccount(from, source);
		Account destination=getAccountById(to);
		destination.setBalance(destination.getBalance()+amount);
		destination=dao.updateAccount(to, destination);
		
	}

}
