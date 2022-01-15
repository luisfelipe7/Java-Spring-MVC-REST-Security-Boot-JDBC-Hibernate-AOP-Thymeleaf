/**
 * 
 */
package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

/**
 * @author Felipe Castro
 *
 */

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT : "+theAccount.toString());
		System.out.println("VIP Client "+vipFlag);
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": EXECUTING doWork()");
		return true;
	}

}
