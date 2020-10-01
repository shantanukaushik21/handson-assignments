package com.hsbc.model.dao;

import com.hsbc.model.beans.Account;

public class ArrayBackedAccountDao implements AccountDao {
	// temporary database
		private static Account[] accountArray = new Account[10];
		
		private static int index = 0;

		@Override
		public Account store(Account account) {
			accountArray[index]=account;
			index++;
			return null;
		}

		@Override
		public Account[] fetchAccouts() {
			return accountArray;
		}

		@Override
		public Account fetchAccountById(int accountNumber) {
			for(int i=0;i<index;i++) {
				if(accountArray[index].getAccountNumber()==accountNumber) {
					return accountArray[index];
				}
			}
			return null;
		}

		@Override
		public Account updateAccount(int accountNumber, Account account) {
			// TODO Auto-generated method stub
			Account temp= account;
			for(int i=0;i<index;i++) {
				if(accountArray[index].getAccountNumber()==accountNumber) {
					accountArray[index]=temp;
					return accountArray[index];
				}
			}
			return null;
		}
}
