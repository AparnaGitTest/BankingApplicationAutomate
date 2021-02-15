package com.bnk.base;

import org.openqa.selenium.By;

import com.bnk.actions.NewCustomer;

public class leftMenuList {

	
	public NewCustomer NewCustomerClick(){
		BaseClass.driver.findElement(By.xpath("//*[text()='New Customer']")).click();
		return new NewCustomer();
		
	}
	public void EditCustomer(){
		
	}
	public void DeleteCustomer(){
		
	}
	public void NewAccount(){
		
	}
	public void EditAccount(){
		
	}
	public void DeleteAccount(){
		
	}
	public void Deposit(){
		
	}
	public void Withdrawal(){
		
	}
	public void FundTransfer(){
		
	}
	public void ChangePassword(){
		
	}
	public void BalanceEnquiry(){
		
	}
	public void MiniStatement(){
		
	}
	public void CustomisedStatement(){
		
	}
	public void Logout(){
		
	}


}
