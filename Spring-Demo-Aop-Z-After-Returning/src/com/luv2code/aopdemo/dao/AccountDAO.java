/**
 * 
 */
package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

/**
 * @author Felipe Castro
 *
 */

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// Add a new method : FindAccounts
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		
		// Create sample accounts 
		Account temp1 = new Account("John","Silver");
		Account temp2 = new Account("Madhu","Platinum");
		Account temp3 = new Account("Luca","Gold");
		
		// Add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT : "+theAccount.toString());
		System.out.println("VIP Client "+vipFlag);
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": EXECUTING doWork()");
		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		System.out.println("Calling GET Method for Name");
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println("Calling SET Method for Name");
		this.name = name;
	}

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		System.out.println("Calling GET Method for ServiceCode");
		return serviceCode;
	}

	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		System.out.println("Calling SET Method for ServiceCode");
		this.serviceCode = serviceCode;
	}
	
	

}
