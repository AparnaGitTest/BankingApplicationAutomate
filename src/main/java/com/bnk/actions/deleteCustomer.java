package com.bnk.actions;

import org.openqa.selenium.support.PageFactory;

import com.bnk.base.Page;
import com.bnk.locators.deleteCustomerLocators;

public class deleteCustomer extends Page {
	public deleteCustomerLocators dlc;
	
	public deleteCustomer()
	{
		this.dlc=new deleteCustomerLocators();
		PageFactory.initElements(driver, this.dlc);
	}
	
	
	public void deleteTheCustomer(String customerId)
	{
		dlc.customerID.sendKeys(customerId);
		dlc.submit.click();
		
	}

}
